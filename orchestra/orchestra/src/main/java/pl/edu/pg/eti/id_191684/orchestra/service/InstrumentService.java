package pl.edu.pg.eti.id_191684.orchestra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pg.eti.id_191684.orchestra.DTOS.*;
import pl.edu.pg.eti.id_191684.orchestra.entity.*;
import pl.edu.pg.eti.id_191684.orchestra.repository.InstrumentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class InstrumentService {

    private final InstrumentRepository instrumentRepository;

    @Autowired
    public InstrumentService(InstrumentRepository instrumentRepository) {
        this.instrumentRepository = instrumentRepository;
    }

    public List<Instrument> getAllInstruments() {
        return instrumentRepository.findAll();
    }

    public Instrument getInstrumentById(UUID id) {
        return instrumentRepository.findById(id).orElse(null);
    }

    public List<Instrument> getInstrumentsBySectionId(UUID sectionId) {
        return instrumentRepository.findBySectionId(sectionId);
    }

    public Instrument saveInstrument(Instrument instrument) {
        return instrumentRepository.save(instrument);
    }

    public void deleteInstrument(UUID id) {
        instrumentRepository.deleteById(id);
    }

    /*
    service takes a DTO and returns an Instrument
    used for PUT
     */
    public Instrument createInstrument(UUID id, InstrumentCreateDTO instrumentCreateDTO) {
        return Instrument.builder()
                .id(id)
                .name(instrumentCreateDTO.getName())
                .production_year(instrumentCreateDTO.getProduction_year())
                .section(Section.builder()
                        .id(instrumentCreateDTO.getSection())
                        .build())
                .build();
    }

    /*
    service takes an Instrument and returns a DTO
    used for GET
     */
    public InstrumentGET createInstrumentGET(Instrument instrument) {
        return InstrumentGET.builder()
                .id(instrument.getId())
                .name(instrument.getName())
                .production_year(instrument.getProduction_year())
                .section(InstrumentGET.Section.builder()
                        .id(instrument.getSection().getId())
                        .name(instrument.getSection().getName())
                        .build())
                .build();
    }

    /*
    service takes a list of Instruments and returns a list of DTOs
    used for GET
     */
    public InstrumentCollectionGET createInstrumentCollectionGET(List<Instrument> instruments){

        return InstrumentCollectionGET.builder()
                .instruments(instruments.stream()
                        .map(instrument -> InstrumentGET.builder()
                                .id(instrument.getId())
                                .name(instrument.getName())
                                .production_year(instrument.getProduction_year())
                                .section(InstrumentGET.Section.builder()
                                        .id(instrument.getSection().getId())
                                        .name(instrument.getSection().getName())
                                        .build())
                                .build())
                        .toList())
                .build();
/*        List<InstrumentCollectionGET> instrumentDTOS = instruments.stream()
                .map(instrument -> new InstrumentDTO(instrument))
                .sorted()
                .collect(Collectors.toList());*/

    }
}
