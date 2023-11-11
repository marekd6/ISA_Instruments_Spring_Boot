package pl.edu.pg.eti.id_191684.orchestra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.edu.pg.eti.id_191684.orchestra.DTOS.SectionCollectionGET;
import pl.edu.pg.eti.id_191684.orchestra.DTOS.SectionGET;
import pl.edu.pg.eti.id_191684.orchestra.DTOS.SectionPUT;
import pl.edu.pg.eti.id_191684.orchestra.converter.SectionFromDTOConverter;
import pl.edu.pg.eti.id_191684.orchestra.converter.SectionToDTOConverter;
import pl.edu.pg.eti.id_191684.orchestra.entity.Section;
import pl.edu.pg.eti.id_191684.orchestra.service.SectionService;

import java.util.List;
import java.util.UUID;

@RestController
public class SectionController {

    private final SectionService service;

    private final SectionToDTOConverter toDTOConverter;

    private final SectionFromDTOConverter fromDTOConverter;


    @Autowired
    public SectionController(SectionService service, SectionToDTOConverter toDTOConverter, SectionFromDTOConverter fromDTOConverter) {
        this.service = service;
        this.toDTOConverter = toDTOConverter;
        this.fromDTOConverter = fromDTOConverter;
    }


    /**
     * GET a Section
     * @param id Section's id
     * @return single Section
     */
    @GetMapping("/api/sections/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    SectionGET readSection(@PathVariable("id") UUID id) {
        return service.getSectionById(id)
                .map(toDTOConverter)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }


    /**
     * CREATE/UPDATE a given Section
     * method can be void or return dto from newly created Section
     * @param id Section's id
     * @param dto request dto for Section
     */
    @PutMapping("/api/sections/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void createSection(@PathVariable("id") UUID id, @RequestBody SectionPUT dto){
        service.saveSection(fromDTOConverter.apply(id, dto));
    }


    /**
     * DELETE a given Section
     * @param id Section
     */
    @DeleteMapping("/api/sections/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSection(@PathVariable UUID id) {
        service.getSectionById(id)
                .ifPresentOrElse(
                        Section -> service.deleteSection(id),
                        () ->{
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }


    /**
     * GET all Sections - Collection
     * @return list of Sections
     */
    @GetMapping("api/sections")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public SectionCollectionGET readSectionCollection() {
        List<Section> sections = service.getAllSections();
        // no Sections
        if (sections.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
        return service.toDTOconvert(sections);
    }

}
