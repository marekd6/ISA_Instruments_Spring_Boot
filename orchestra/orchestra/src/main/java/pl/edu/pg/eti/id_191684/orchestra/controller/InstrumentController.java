package pl.edu.pg.eti.id_191684.orchestra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.edu.pg.eti.id_191684.orchestra.DTOS.InstrumentCollectionGET;
import pl.edu.pg.eti.id_191684.orchestra.DTOS.InstrumentGET;
import pl.edu.pg.eti.id_191684.orchestra.DTOS.InstrumentPUT;
import pl.edu.pg.eti.id_191684.orchestra.converter.InstrumentCollectionToDTOConverter;
import pl.edu.pg.eti.id_191684.orchestra.converter.InstrumentFromDTOConverter;
import pl.edu.pg.eti.id_191684.orchestra.converter.InstrumentToDTOConverter;
import pl.edu.pg.eti.id_191684.orchestra.service.InstrumentService;

import java.util.UUID;

@RestController
public class InstrumentController {

    private final InstrumentService service;

    private final InstrumentToDTOConverter toDTOConverter;

    private final InstrumentFromDTOConverter fromDTOConverter;

    private final InstrumentCollectionToDTOConverter collectionToDTOConverter;


    @Autowired
    public InstrumentController(InstrumentService service, InstrumentToDTOConverter toDTOConverter, InstrumentFromDTOConverter fromDTOConverter, InstrumentCollectionToDTOConverter collectionToDTOConverter) {
        this.service = service;
        this.toDTOConverter = toDTOConverter;
        this.fromDTOConverter = fromDTOConverter;
        this.collectionToDTOConverter = collectionToDTOConverter;
    }


    /**
     * GET an Instrument
     * @param id instrument's id
     * @return single instrument
     */
    @GetMapping("/api/instruments/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    InstrumentGET readInstrument(@PathVariable("id") UUID id) {
        return service.getInstrumentById(id)
                .map(toDTOConverter)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }


    /**
     * GET an Instrument from a Section
     * @param sectionId section's id
     * @param instrumentId instrument's id
     * @return single instrument
     */
    @GetMapping("api/sections/{sectionId}/instruments/{instrumentId}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    InstrumentGET readInstrument(@PathVariable("sectionId") UUID sectionId, @PathVariable("instrumentId") UUID instrumentId) {
        return service.getInstrumentById(sectionId, instrumentId)
                .map(toDTOConverter)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }


    /**
     * CREATE/UPDATE a given Instrument
     * method can be void or return dto from newly created Instrument
     * @param instrumentId instrument's id
     * @param dto request dto for instrument
     */
    @PutMapping("/api/sections/{sectionId}/{instrumentId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void createInstrument(@PathVariable("instrumentId") UUID instrumentId, @PathVariable("sectionId") UUID sectionId, @RequestBody InstrumentPUT dto){
        service.saveInstrument(fromDTOConverter.apply(instrumentId, dto));
    }


    /**
     * DELETE a given Instrument
     * @param id Instrument
     */
    @DeleteMapping("/api/instruments/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteInstrument(@PathVariable UUID id) {
        service.getInstrumentById(id)
                .ifPresentOrElse(
                        instrument -> service.deleteInstrument(id),
                        () ->{
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }


    /**
     * GET all Instruments - Collection
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


    // TODO differentiate between no section and empty section
    /**
     * GET all Instruments from a given Section - Collection
     * @param sectionId Section to read Instruments from
     * @return list of Instruments
     */
    @GetMapping("api/sections/{sectionId}/instruments")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public InstrumentCollectionGET readSectionInstruments(@PathVariable("sectionId") UUID sectionId){
        return service.getInstrumentsBySectionId(sectionId)
                .map(collectionToDTOConverter)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }


}
