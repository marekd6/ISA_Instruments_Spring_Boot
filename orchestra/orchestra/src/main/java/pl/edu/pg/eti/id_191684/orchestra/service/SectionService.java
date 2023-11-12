package pl.edu.pg.eti.id_191684.orchestra.service;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pg.eti.id_191684.orchestra.DTOS.SectionCollectionGET;
import pl.edu.pg.eti.id_191684.orchestra.entity.Section;
import pl.edu.pg.eti.id_191684.orchestra.repository.SectionRepository;

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
        return sectionRepository.save(section);
    }

    public void deleteSection(UUID id) {
        sectionRepository.deleteById(id);
    }

}
