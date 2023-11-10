package pl.edu.pg.eti.id_191684.orchestra.service;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pg.eti.id_191684.orchestra.DTOS.*;
import pl.edu.pg.eti.id_191684.orchestra.entity.*;
import pl.edu.pg.eti.id_191684.orchestra.repository.InstrumentRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

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

    /*public Instrument getInstrumentById(UUID id) {
        return instrumentRepository.findById(id).orElse(null);
    }*/
    public Optional<Instrument> getInstrumentById(UUID id) {
        return instrumentRepository.findById(id);
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

    /**
     * used in PUT
     * converts a DTO into an Instrument
     * @param dto request for Instrument
     * @return Instrument
     */
    public Instrument fromDTOconvert(UUID id, InstrumentPUT dto) {
        return Instrument.builder()
                .id(id)
                .name(dto.getName())
                .production_year(dto.getProduction_year())
                .section(Section.builder()
                        .id(dto.getSectionId())
                        .build())
                .build();
    }

    /**
     * substituted by converter
     * used in GET
     * @param instrument
     * @return DTO
     */
    public InstrumentDTO toDTOconvert(@NotNull Instrument instrument) {
        return InstrumentDTO.builder()
                .id(instrument.getId())
                .name(instrument.getName())
                .production_year(instrument.getProduction_year())
                .section(InstrumentDTO.Section.builder()
                        .id(instrument.getSection().getId())
                        .name(instrument.getSection().getName())
                        .build())
                .build();
    }

    /**
     * used in GET
     * @param instruments
     * @return DTO collection of Instruments
     */
    public InstrumentCollectionDTO toDTOconvert(@NotNull List<Instrument> instruments){
        List<UUID> uuids = instruments.stream()
                .map(instrument -> instrument.getId())
                .toList();
        return InstrumentCollectionDTO.builder()
                .instruments(uuids)
                .build();
    }

}
