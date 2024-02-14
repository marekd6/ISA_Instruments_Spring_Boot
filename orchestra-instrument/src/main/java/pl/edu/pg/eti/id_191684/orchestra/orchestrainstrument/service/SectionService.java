package pl.edu.pg.eti.id_191684.orchestra.orchestrainstrument.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pg.eti.id_191684.orchestra.orchestrainstrument.entity.Section;
import pl.edu.pg.eti.id_191684.orchestra.orchestrainstrument.repository.SectionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SectionService {

    private final SectionRepository sectionRepository;

    @Autowired
    public SectionService(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }

    public Optional<List<Section>> getAllSections() {
        return Optional.of(sectionRepository.findAll());
    }

    public Optional< Section> getSectionById(UUID id) {
        return sectionRepository.findById(id);
    }

    public Section saveSection(Section section) {
        /*if (section.getInstrumentList() == null) { // może jednak nie jest potrzebne
            section.setInstrumentList(new ArrayList<>());
        }*/
        return sectionRepository.save(section);
    }

    public void deleteSection(UUID id) {
        sectionRepository.deleteById(id);
    }

}
