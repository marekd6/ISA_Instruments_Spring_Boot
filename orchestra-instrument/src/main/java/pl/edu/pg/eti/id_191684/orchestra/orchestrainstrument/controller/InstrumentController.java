package pl.edu.pg.eti.id_191684.orchestra.orchestrainstrument.controller;

import org.antlr.v4.runtime.misc.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.edu.pg.eti.id_191684.orchestra.orchestrainstrument.DTOS.InstrumentCollectionGET;
import pl.edu.pg.eti.id_191684.orchestra.orchestrainstrument.DTOS.InstrumentGET;
import pl.edu.pg.eti.id_191684.orchestra.orchestrainstrument.DTOS.InstrumentPUT;
import pl.edu.pg.eti.id_191684.orchestra.orchestrainstrument.DTOS.SectionGET;
import pl.edu.pg.eti.id_191684.orchestra.orchestrainstrument.converter.InstrumentCollectionToDTOConverter;
import pl.edu.pg.eti.id_191684.orchestra.orchestrainstrument.converter.InstrumentFromDTOConverter;
import pl.edu.pg.eti.id_191684.orchestra.orchestrainstrument.converter.InstrumentToDTOConverter;
import pl.edu.pg.eti.id_191684.orchestra.orchestrainstrument.converter.SectionFromDTOConverter;
import pl.edu.pg.eti.id_191684.orchestra.orchestrainstrument.service.InstrumentService;
import pl.edu.pg.eti.id_191684.orchestra.orchestrainstrument.service.SectionService;

import java.util.UUID;

@RestController
public class InstrumentController {

    private final InstrumentService service;

    private final SectionService sectionService;

    private final InstrumentToDTOConverter toDTOConverter;

    private final InstrumentFromDTOConverter fromDTOConverter;

    private final InstrumentCollectionToDTOConverter collectionToDTOConverter;
    private final SectionFromDTOConverter sectionFromDTOConverter;

    @Autowired
    public InstrumentController(InstrumentService service, SectionService sectionService, InstrumentToDTOConverter toDTOConverter, InstrumentFromDTOConverter fromDTOConverter, InstrumentCollectionToDTOConverter collectionToDTOConverter, SectionFromDTOConverter sectionFromDTOConverter) {
        this.service = service;
        this.sectionService = sectionService;
        this.toDTOConverter = toDTOConverter;
        this.fromDTOConverter = fromDTOConverter;
        this.collectionToDTOConverter = collectionToDTOConverter;
        this.sectionFromDTOConverter = sectionFromDTOConverter;
    }

    /**
     * GET an Instrument
     *
     * @param id instrument's id
     * @return single instrument
     */
    @GetMapping("/api/instruments/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public InstrumentGET readInstrument(@PathVariable("id") UUID id) {
        return service.getInstrumentById(id)
                .map(toDTOConverter)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)); // no instrument
    }

    /**
     * GET an Instrument from a Section
     *
     * @param sectionId    section's id
     * @param instrumentId instrument's id
     * @return single instrument
     */
    @GetMapping("api/sections/{sectionId}/instruments/{instrumentId}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public InstrumentGET readInstrument(@PathVariable("sectionId") UUID sectionId, @PathVariable("instrumentId") UUID instrumentId) {
        if (sectionService.getSectionById(sectionId).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND); // no section
        } else {
            return service.getInstrumentByIdAndSection(instrumentId, sectionService.getSectionById(sectionId).get())
                    .map(toDTOConverter)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)); // no instrument
        }
    }

    /**
     * CREATE/UPDATE a given Instrument
     *
     * @param instrumentId instrument's id
     * @param sectionId    section's id
     * @param dto          request dto for instrument
     */
    @PutMapping("/api/sections/{sectionId}/instruments/{instrumentId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void createInstrument(@PathVariable("instrumentId") UUID instrumentId, @PathVariable("sectionId") UUID sectionId, @RequestBody InstrumentPUT dto) {
        sectionService.getSectionById(sectionId)
                .ifPresentOrElse(section -> {
                            service.saveInstrument(fromDTOConverter.apply(new Pair<>(instrumentId, sectionId), dto));
                        }, () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND); // no such a section
                        }
                );
    }

    /**
     * DELETE a given Instrument
     *
     * @param id Instrument
     */
    @DeleteMapping("/api/instruments/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteInstrument(@PathVariable UUID id) {
        service.getInstrumentById(id)
                .ifPresentOrElse(
                        instrument -> service.deleteInstrument(id),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }

    /**
     * DELETE a given Instrument
     * @param sectionId Section
     * @param instrumentId Instrument
     */
    @DeleteMapping("/api/sections/{sectionId}/instruments/{instrumentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteInstrument(@PathVariable UUID instrumentId, @PathVariable("sectionId") UUID sectionId) {
        sectionService.getSectionById(sectionId)
                .ifPresentOrElse(section -> {
                            service.getInstrumentById(instrumentId)
                                    .ifPresentOrElse(
                                           instrument -> service.deleteInstrument(instrumentId),
                                            () -> {
                                                throw new ResponseStatusException(HttpStatus.NOT_FOUND); // no such an instrument
                                            }
                                    );
                        }, () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND); // no such a section
                        }
                );

    }

    /**
     * GET all Instruments - Collection
     *
     * @return list of Instruments
     */
    @GetMapping("api/instruments")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public InstrumentCollectionGET readInstrumentCollection() {
        return service.getAllInstruments()
                .map(collectionToDTOConverter)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    /**
     * GET all Instruments from a given Section - Collection
     *
     * @param sectionId Section to read Instruments from
     * @return list of Instruments
     */
    @GetMapping("api/sections/{sectionId}/instruments")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public InstrumentCollectionGET readSectionInstruments(@PathVariable("sectionId") UUID sectionId) {
        if (sectionService.getSectionById(sectionId).isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND); // no section

        InstrumentCollectionGET instrumentCollectionGET = service.getInstrumentsBySectionId(sectionId)
                .map(collectionToDTOConverter)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)); // no section

        // the section has no instruments
        if (instrumentCollectionGET.getInstruments().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }

        String sectionName = sectionService.getSectionById(sectionId).get().getName();
        instrumentCollectionGET.setDescription("Collection of Instruments from section " + sectionName);
        return instrumentCollectionGET;

    }

    /**
     * DELETE a given Section with its Instruments
     * @param id Section id
     */
    @DeleteMapping("/api/sections/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSectionAndInstruments(@PathVariable("id") UUID id) {
        sectionService.getSectionById(id)
                .ifPresentOrElse(
                        Section -> sectionService.deleteSection(id), // cascade remove Instruments
                        () ->{
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND); // no section
                        }
                );

    }

    /**
     * CREATE/UPDATE a given Section
     * @param id Section's id
     * @param dto request dto for Section
     */
    @PutMapping("/api/sections/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void createSection(@PathVariable("id") UUID id, @RequestBody SectionGET dto){
        sectionService.saveSection(sectionFromDTOConverter.apply(id, dto));
    }

}
