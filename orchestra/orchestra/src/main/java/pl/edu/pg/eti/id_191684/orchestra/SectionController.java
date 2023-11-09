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
    public ResponseEntity<SectionGET> createSection(@RequestBody SectionPUT sectionPUT) {
        Section section = sectionService.createSection(sectionPUT);
        SectionGET sectionGET = convertToDTO(section);
        return new ResponseEntity<>(sectionGET, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SectionGET> updateSection(@PathVariable UUID id, @RequestBody SectionPUT sectionPUT) {
        Section section = sectionService.updateSection(id, sectionPUT);
        SectionGET sectionGET = convertToDTO(section);
        return new ResponseEntity<>(sectionGET, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSection(@PathVariable UUID id) {
        sectionService.deleteSection(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SectionGET> getSectionById(@PathVariable UUID id) {
        Section section = sectionService.getSectionById(id);
        if (section != null) {
            SectionGET sectionGET = convertToDTO(section);
            return new ResponseEntity<>(sectionGET, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<SectionCollectionGET> getAllSections() {
        List<Section> sections = sectionService.getAllSections();
        SectionCollectionGET collectionDTO = convertToSectionCollectionDTO(sections);
        return new ResponseEntity<>(collectionDTO, HttpStatus.OK);
    }

    private SectionGET convertToDTO(Section section) {
        // Convert Section entity to SectionGET
        return null;
    }

    private SectionCollectionGET convertToSectionCollectionDTO(List<Section> sections) {
        // Convert List<Section> to SectionCollectionGET
        return null;
    }
}
