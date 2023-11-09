package pl.edu.pg.eti.id_191684.orchestra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pg.eti.id_191684.orchestra.DTOS.*;
import pl.edu.pg.eti.id_191684.orchestra.entity.*;
import pl.edu.pg.eti.id_191684.orchestra.service.InstrumentService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/instruments")
public class InstrumentController {

    private final InstrumentService instrumentService;

    @Autowired
    public InstrumentController(InstrumentService instrumentService) {
        this.instrumentService = instrumentService;
    }



/*    @PostMapping
    public ResponseEntity<InstrumentDTO> createInstrument(@RequestBody InstrumentCreateDTO instrumentCreateDTO) {
        Instrument instrument = instrumentService.createInstrument(instrumentCreateDTO);
        InstrumentDTO instrumentDTO = convertToDTO(instrument);
        return new ResponseEntity<>(instrumentDTO, HttpStatus.CREATED);
    }*/
    @PutMapping("/api/instruments/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void putCharacter(@PathVariable("id") UUID id, @RequestBody InstrumentPUT instrumentPUT){
        //instrumentService.createInstrument(id, instrumentCreateDTO);
        instrumentService.saveInstrument(createInstrument(instrumentPUT));
    }

    private Instrument createInstrument(InstrumentPUT instrumentPUT) {
        return Instrument.builder()
                .name(instrumentPUT.getName())
                .production_year(instrumentPUT.getProduction_year())
                .section(instrumentPUT.)
    }


/*    @PutMapping("/{id}")
    public ResponseEntity<InstrumentDTO> updateInstrument(@PathVariable UUID id, @RequestBody InstrumentCreateDTO instrumentCreateDTO) {
        Instrument instrument = instrumentService.updateInstrument(id, instrumentCreateDTO);
        InstrumentDTO instrumentDTO = convertToDTO(instrument);
        return new ResponseEntity<>(instrumentDTO, HttpStatus.OK);
    }*/

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInstrument(@PathVariable UUID id) {
        instrumentService.deleteInstrument(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

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

    /**
     * @param id instrument's id
     * @return single instrument
     */
    @GetMapping("/api/instruments/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    InstrumentGET getInstrument(@PathVariable("id") UUID id) {
        Instrument instrument = instrumentService.getInstrumentById(id);
        return instrumentService.createInstrumentGET(instrument);
        /*return instrumentService.getInstrumentById(id)
                .map(InstrumentDTO)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));*/
    }



/*    @GetMapping
    public ResponseEntity<InstrumentCollectionGET> getAllInstruments() {
        List<Instrument> instruments = instrumentService.getAllInstruments();
        InstrumentCollectionGET collectionDTO = convertToInstrumentCollectionDTO(instruments);
        return new ResponseEntity<>(collectionDTO, HttpStatus.OK);
    }*/


    /**
     * @return list of instruments
     */
    @GetMapping("api/instruments")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public InstrumentCollectionGET getAllInstruments() {
        //return charactersToResponse.apply(service.findAll());
        //InstrumentCollectionGET instrumentCollectionGET = convertToInstrumentCollectionDTO(instruments);
        List<Instrument> instruments = instrumentService.getAllInstruments();
        return instrumentService.createInstrumentCollectionGET(instruments);
    }

}
