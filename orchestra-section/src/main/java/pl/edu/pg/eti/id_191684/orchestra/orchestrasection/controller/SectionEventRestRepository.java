package pl.edu.pg.eti.id_191684.orchestra.orchestrasection.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;
import pl.edu.pg.eti.id_191684.orchestra.orchestrasection.converter.SectionToDTOConverter;
import pl.edu.pg.eti.id_191684.orchestra.orchestrasection.entity.Section;

import java.util.UUID;

@Repository
public class SectionEventRestRepository {

    private final RestTemplate restTemplate;

    private final SectionToDTOConverter converter;

    /**
     * Load balancer (with discovery) client.
     */
    private final LoadBalancerClient loadBalancerClient;

    @Autowired
    public SectionEventRestRepository(RestTemplate template, SectionToDTOConverter converter, LoadBalancerClient loadBalancerClient) {
        this.restTemplate = template;
        this.converter = converter;
        this.loadBalancerClient = loadBalancerClient;
    }

    /**
     * call orchestra-instrument and create a section
     * @param section Section, transformed into a DTO
     */
    public void create(@PathVariable("id") UUID id, Section section){
        String uri = loadBalancerClient.choose("orchestra-instrument").getUri().toString();
        restTemplate.put(uri + "/api/sections/{id}", converter.apply(section), id);
    }

    /**
     * call orchestra-instrument and delete a section with instruments
     * @param id section id
     */
    public void delete(@PathVariable("id") UUID id) {
        String uri = loadBalancerClient.choose("orchestra-instrument").getUri().toString();
        restTemplate.delete(uri + "/api/sections/{id}", id);
    }

}
