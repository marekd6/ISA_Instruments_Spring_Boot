package pl.edu.pg.eti.id_191684.orchestra.service;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pg.eti.id_191684.orchestra.DTOS.InstrumentCollectionGET;
import pl.edu.pg.eti.id_191684.orchestra.entity.Instrument;
import pl.edu.pg.eti.id_191684.orchestra.repository.InstrumentRepository;
import pl.edu.pg.eti.id_191684.orchestra.repository.SectionRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class InstrumentService {

    private final InstrumentRepository instrumentRepository;
    private final SectionRepository sectionRepository;

    @Autowired
    public InstrumentService(InstrumentRepository instrumentRepository, SectionRepository sectionRepository) {
        this.instrumentRepository = instrumentRepository;
        this.sectionRepository = sectionRepository;
    }

/*    public List<Instrument> getAllInstruments() {
        return instrumentRepository.findAll();
    }*/

    public Optional<List<Instrument>> getAllInstruments() {
        return Optional.of(instrumentRepository.findAll());
    }

    /*public Instrument getInstrumentById(UUID id) {
        return instrumentRepository.findById(id).orElse(null);
    }*/
    public Optional<Instrument> getInstrumentById(UUID id) {
        return instrumentRepository.findById(id);
    }

    // TODO an instrument from a section
    public Optional<Instrument> getInstrumentById(UUID section, UUID id) {
        return instrumentRepository.findByIdAndSection(id, section);
    }

    public Optional<List<Instrument>> getInstrumentsBySectionId(UUID sectionId) {
        return sectionRepository.findById(sectionId)
                .map(section -> instrumentRepository.findAllBySection(section));
    }

    public void saveInstrument(Instrument instrument) {
        instrumentRepository.save(instrument);
    }

    public void deleteInstrument(UUID id) {
        instrumentRepository.deleteById(id);
    }


    /**
     * substituted by another converter
     * used in GET
     * @param instruments
     * @return DTO collection of Instruments
     */
    public InstrumentCollectionGET toDTOconvert(@NotNull List<Instrument> instruments){
        List<UUID> uuids = instruments.stream()
                .map(instrument -> instrument.getId())
                .toList();
        return InstrumentCollectionGET.builder()
                .instruments(uuids)
                .build();
    }

}
