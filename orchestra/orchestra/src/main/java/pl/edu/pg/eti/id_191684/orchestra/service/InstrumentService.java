package pl.edu.pg.eti.id_191684.orchestra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pg.eti.id_191684.orchestra.DTOS.InstrumentCreateDTO;
import pl.edu.pg.eti.id_191684.orchestra.entity.Instrument;
import pl.edu.pg.eti.id_191684.orchestra.entity.Section;
import pl.edu.pg.eti.id_191684.orchestra.repository.InstrumentRepository;

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

    public Instrument createInstrument(UUID id, InstrumentCreateDTO instrumentCreateDTO) {
        Instrument.builder()
                .id(id)
                .name(instrumentCreateDTO.getName())
                .production_year(instrumentCreateDTO.getProduction_year())
                .section(Section.builder()
                        .id(instrumentCreateDTO.getSection())
                        .build())
                .build();
    }
}
