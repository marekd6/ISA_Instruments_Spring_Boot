package pl.edu.pg.eti.id_191684.orchestra.orchestrasection.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;
import pl.edu.pg.eti.id_191684.orchestra.orchestrasection.converter.SectionToDTOConverter;
import pl.edu.pg.eti.id_191684.orchestra.orchestrasection.entity.Section;

import java.util.UUID;

@Repository
public class SectionEventRestRepository {

    /**
     * Configured rest template.
     */
    private final RestTemplate restTemplate;

    private final SectionToDTOConverter converter;

    @Autowired
    public SectionEventRestRepository(RestTemplate template, SectionToDTOConverter converter) {
        this.restTemplate = template;
        this.converter = converter;
    }

    /**
     * call orchestra-instrument and create a section
     * @param section Section, transformed into a DTO
     */
    public void create(@PathVariable("id") UUID id, Section section){
        restTemplate.put("/api/instruments/sections/{id}", converter.apply(section), id);
/*        restTemplate.exchange("/api/instruments/sections/{id}",
                HttpMethod.PUT, new HttpEntity<>(converter.apply(section), new HttpHeaders()),
                section.getClass(), id);*/
    }

    /**
     * call orchestra-instrument and delete a section with instruments
     * @param id section id
     */
    public void delete(@PathVariable("id") UUID id) {
        //restTemplate.delete("/api/sections/{id}", id);
        restTemplate.delete("/api/instruments/sections/{id}", id);
        //restTemplate.delete("/api/instruments/sections/{id}");
    }

}
