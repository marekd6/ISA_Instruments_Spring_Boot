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

    @PostMapping
    public ResponseEntity<InstrumentDTO> createInstrument(@RequestBody InstrumentCreateDTO instrumentCreateDTO) {
        Instrument instrument = instrumentService.createInstrument(instrumentCreateDTO);
        InstrumentDTO instrumentDTO = convertToDTO(instrument);
        return new ResponseEntity<>(instrumentDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InstrumentDTO> updateInstrument(@PathVariable UUID id, @RequestBody InstrumentCreateDTO instrumentCreateDTO) {
        Instrument instrument = instrumentService.updateInstrument(id, instrumentCreateDTO);
        InstrumentDTO instrumentDTO = convertToDTO(instrument);
        return new ResponseEntity<>(instrumentDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInstrument(@PathVariable UUID id) {
        instrumentService.deleteInstrument(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InstrumentDTO> getInstrumentById(@PathVariable UUID id) {
        Instrument instrument = instrumentService.getInstrumentById(id);
        if (instrument != null) {
            InstrumentDTO instrumentDTO = convertToDTO(instrument);
            return new ResponseEntity<>(instrumentDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<InstrumentCollectionDTO> getAllInstruments() {
        List<Instrument> instruments = instrumentService.getAllInstruments();
        InstrumentCollectionDTO collectionDTO = convertToInstrumentCollectionDTO(instruments);
        return new ResponseEntity<>(collectionDTO, HttpStatus.OK);
    }

    private InstrumentDTO convertToDTO(Instrument instrument) {
        // Convert Instrument entity to InstrumentDTO
        return null;
    }

    private InstrumentCollectionDTO convertToInstrumentCollectionDTO(List<Instrument> instruments) {
        // Convert List<Instrument> to InstrumentCollectionDTO
        return null;
    }
}
