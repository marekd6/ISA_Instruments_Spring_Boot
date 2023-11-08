package pl.edu.pg.eti.id_191684.orchestra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pg.eti.id_191684.orchestra.DTOS.*;
import pl.edu.pg.eti.id_191684.orchestra.entity.*;
import pl.edu.pg.eti.id_191684.orchestra.service.SectionService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/sections")
public class SectionController {

    private final SectionService sectionService;

    @Autowired
    public SectionController(SectionService sectionService) {
        this.sectionService = sectionService;
    }

    @PostMapping
    public ResponseEntity<SectionDTO> createSection(@RequestBody SectionCreateDTO sectionCreateDTO) {
        Section section = sectionService.createSection(sectionCreateDTO);
        SectionDTO sectionDTO = convertToDTO(section);
        return new ResponseEntity<>(sectionDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SectionDTO> updateSection(@PathVariable UUID id, @RequestBody SectionCreateDTO sectionCreateDTO) {
        Section section = sectionService.updateSection(id, sectionCreateDTO);
        SectionDTO sectionDTO = convertToDTO(section);
        return new ResponseEntity<>(sectionDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSection(@PathVariable UUID id) {
        sectionService.deleteSection(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SectionDTO> getSectionById(@PathVariable UUID id) {
        Section section = sectionService.getSectionById(id);
        if (section != null) {
            SectionDTO sectionDTO = convertToDTO(section);
            return new ResponseEntity<>(sectionDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<SectionCollectionDTO> getAllSections() {
        List<Section> sections = sectionService.getAllSections();
        SectionCollectionDTO collectionDTO = convertToSectionCollectionDTO(sections);
        return new ResponseEntity<>(collectionDTO, HttpStatus.OK);
    }

    private SectionDTO convertToDTO(Section section) {
        // Convert Section entity to SectionDTO
        return null;
    }

    private SectionCollectionDTO convertToSectionCollectionDTO(List<Section> sections) {
        // Convert List<Section> to SectionCollectionDTO
        return null;
    }
}
