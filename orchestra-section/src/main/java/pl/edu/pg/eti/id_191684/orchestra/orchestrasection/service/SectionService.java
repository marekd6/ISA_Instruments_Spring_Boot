package pl.edu.pg.eti.id_191684.orchestra.orchestrasection.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pg.eti.id_191684.orchestra.orchestrasection.controller.SectionEventRestRepository;
import pl.edu.pg.eti.id_191684.orchestra.orchestrasection.entity.Section;
import pl.edu.pg.eti.id_191684.orchestra.orchestrasection.repository.SectionRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SectionService {

    private final SectionRepository sectionRepository;

    private final SectionEventRestRepository sectionEventRestRepository;

    @Autowired
    public SectionService(SectionRepository sectionRepository, SectionEventRestRepository sectionEventRestRepository) {
        this.sectionRepository = sectionRepository;
        this.sectionEventRestRepository = sectionEventRestRepository;
    }

    public Optional<List<Section>> getAllSections() {
        return Optional.of(sectionRepository.findAll());
    }

    public Optional<Section> getSectionById(UUID id) {
        return sectionRepository.findById(id);
    }

    public Section saveSection2(Section section) {
        return sectionRepository.save(section);
    }
    public Section saveSection(Section section) {
        sectionEventRestRepository.create(section.getId(), section);
        return sectionRepository.save(section);
    }

    /**
     * removes section with instruments
     * @param id section id
     */
    public void deleteSection(UUID id) {
        sectionRepository.deleteById(id);
        sectionEventRestRepository.delete(id);
    }

}
