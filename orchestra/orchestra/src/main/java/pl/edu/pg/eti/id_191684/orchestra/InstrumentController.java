package pl.edu.pg.eti.id_191684.orchestra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.edu.pg.eti.id_191684.orchestra.DTOS.*;
import pl.edu.pg.eti.id_191684.orchestra.converter.InstrumentToDTOconv;
import pl.edu.pg.eti.id_191684.orchestra.entity.*;
import pl.edu.pg.eti.id_191684.orchestra.service.InstrumentService;

import java.util.List;
import java.util.UUID;

@RestController
//@RequestMapping("/api/instruments")
public class InstrumentController {

    private final InstrumentService service;

    private final InstrumentToDTOconv toDTOconv;

    // TODO no converter needed: conversion in service
    // generally, model (entity), controller (this), dtos, service, repo - all OK
    // TODO CRUD operations can be with single dto per entity
    //https://www.youtube.com/watch?v=THv-TI1ZNMk good as well
    // TODO or, according to the example, there can be separate Component converter(s)
    // Instrument GET, DEL by converter
    // InstrumentCollection GET by service method

    @Autowired
    public InstrumentController(InstrumentService service, InstrumentToDTOconv toDTOconv) {
        this.service = service;
        this.toDTOconv = toDTOconv;
    }

    /**
     * @param id instrument's id
     * @return single instrument
     */
    @GetMapping("/api/instruments/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    InstrumentDTO readInstrument(@PathVariable("id") UUID id) {
        //Instrument instrument = instrumentService.getInstrumentById(id);
        //return instrumentService.toDTOconvert(instrument);
        return service.getInstrumentById(id)
                .map(toDTOconv)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    /**
     * method can be void or return dto from newly created Instrument
     * @param id instrument's id
     * @param dto request dto for instrument
     * ///@return dto of instrument
     * // to tak jalby wysyłać PUT na /instruments/ i wtedy się dodaje i nadaje ID automat
     */
    @PutMapping("/api/instruments/{id}")//or put and then create/update
    @ResponseStatus(HttpStatus.CREATED)
    public void createInstrument(@PathVariable("id") UUID id, @RequestBody InstrumentPUT dto){
        Instrument instrument = service.fromDTOconvert(id, dto);
        service.saveInstrument(instrument);
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
     * GET all Instruments
     * @return list of Instruments
     */
    @GetMapping("api/instruments")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public InstrumentCollectionDTO readInstrumentCollection() {
        List<Instrument> instruments = service.getAllInstruments();
        return service.toDTOconvert(instruments);
    }


/*    @PostMapping
    public ResponseEntity<InstrumentDTO> createInstrument(@RequestBody InstrumentCreateDTO instrumentCreateDTO) {
        Instrument instrument = instrumentService.createInstrument(instrumentCreateDTO);
        InstrumentDTO instrumentDTO = convertToDTO(instrument);
        return new ResponseEntity<>(instrumentDTO, HttpStatus.CREATED);
    }*/
/*    @PutMapping("/api/instruments/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void putCharacter(@PathVariable("id") UUID id, @RequestBody InstrumentPUT instrumentPUT){
        //instrumentService.createInstrument(id, instrumentCreateDTO);
        instrumentService.saveInstrument(createInstrument(instrumentPUT));
    }*/

/*    private Instrument createInstrument(InstrumentPUT instrumentPUT) {
        return Instrument.builder()
                .name(instrumentPUT.getName())
                .production_year(instrumentPUT.getProduction_year())
                //.section(instrumentPUT.)
                .build();
    }*/

/*    @PutMapping("/{id}")
    public ResponseEntity<InstrumentDTO> updateInstrument(@PathVariable UUID id, @RequestBody InstrumentCreateDTO instrumentCreateDTO) {
        Instrument instrument = instrumentService.updateInstrument(id, instrumentCreateDTO);
        InstrumentDTO instrumentDTO = convertToDTO(instrument);
        return new ResponseEntity<>(instrumentDTO, HttpStatus.OK);
    }*/


/*    @GetMapping("/{id}")
    public ResponseEntity<InstrumentDTO> getInstrumentById(@PathVariable UUID id) {
        Instrument instrument = instrumentService.getInstrumentById(id);
        if (instrument != null) {
            InstrumentDTO instrumentDTO = convertToDTO(instrument);
            return new ResponseEntity<>(instrumentDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }*/


/*    @GetMapping
    public ResponseEntity<InstrumentCollectionDTO> getAllInstruments() {
        List<Instrument> instruments = instrumentService.getAllInstruments();
        InstrumentCollectionDTO collectionDTO = convertToInstrumentCollectionDTO(instruments);
        return new ResponseEntity<>(collectionDTO, HttpStatus.OK);
    }*/

}
