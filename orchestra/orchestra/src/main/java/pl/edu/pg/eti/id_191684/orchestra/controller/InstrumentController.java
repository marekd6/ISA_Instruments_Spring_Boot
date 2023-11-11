package pl.edu.pg.eti.id_191684.orchestra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.edu.pg.eti.id_191684.orchestra.DTOS.InstrumentCollectionGET;
import pl.edu.pg.eti.id_191684.orchestra.DTOS.InstrumentGET;
import pl.edu.pg.eti.id_191684.orchestra.DTOS.InstrumentPUT;
import pl.edu.pg.eti.id_191684.orchestra.converter.InstrumentFromDTOConverter;
import pl.edu.pg.eti.id_191684.orchestra.converter.InstrumentToDTOConverter;
import pl.edu.pg.eti.id_191684.orchestra.entity.Instrument;
import pl.edu.pg.eti.id_191684.orchestra.service.InstrumentService;

import java.util.List;
import java.util.UUID;

@RestController
public class InstrumentController {

    private final InstrumentService service;

    private final InstrumentToDTOConverter toDTOConverter;

    private final InstrumentFromDTOConverter fromDTOConverter;


    @Autowired
    public InstrumentController(InstrumentService service, InstrumentToDTOConverter toDTOConverter, InstrumentFromDTOConverter fromDTOConverter) {
        this.service = service;
        this.toDTOConverter = toDTOConverter;
        this.fromDTOConverter = fromDTOConverter;
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


    // TODO an instrument from a section: to w końcu uuid czy Section?
    // TODO nie jestem pewien czy to potrzebne
/*    @GetMapping("api/sections/{sectionId}/instruments/{instrumentId}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    InstrumentGET readInstrument(@PathVariable("sectionId") UUID sectionId, @PathVariable("instrumentId") UUID instrumentId) {
        return service.getInstrumentsBySectionId(sectionId)
                .stream()
                .filter(instrument -> instrument.get)
                //.getInstrumentById(sectionId, instrumentId)
                .map(toDTOConverter)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        *//*return service.getInstrumentById(id)
                .map(toDTOConverter)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));*//*
    }*/


    /**
     * CREATE/UPDATE a given Instrument
     * method can be void or return dto from newly created Instrument
     * @param id instrument's id
     * @param dto request dto for instrument
     */
    @PutMapping("/api/instruments/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void createInstrument(@PathVariable("id") UUID id, @RequestBody InstrumentPUT dto){
        service.saveInstrument(fromDTOConverter.apply(id, dto));
    }


    /**
     * DELETE a given Instrument
     * @param id Instrument
     */
    @DeleteMapping("/api/instruments/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteInstrument(@PathVariable UUID id) {
        //instrumentService.deleteInstrument(id);
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
        List<Instrument> instruments = service.getAllInstruments();
        // no Instruments
        if (instruments.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
        return service.toDTOconvert(instruments);
    }


    // TODO differentiate between no section and empty section
    // TODO no for Optional in here
    /**
     * GET all Instruments from a given Section - Collection
     * @param sectionId Section to read Instruments from
     * @return list of Instruments
     */
    @GetMapping("api/sections/{sectionId}/instruments")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public InstrumentCollectionGET readSectionInstruments(@PathVariable("sectionId") UUID sectionId){
        List<Instrument> instruments = service.getInstrumentsBySectionId(sectionId);
        // no such a Section
        if (instruments == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        // no Instruments
        else if (instruments.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
                //.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return service.toDTOconvert(instruments);
    }


}
