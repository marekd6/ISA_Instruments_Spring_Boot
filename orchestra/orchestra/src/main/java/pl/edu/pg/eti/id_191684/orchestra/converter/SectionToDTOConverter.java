package pl.edu.pg.eti.id_191684.orchestra.converter;

import org.springframework.stereotype.Component;
import pl.edu.pg.eti.id_191684.orchestra.DTOS.SectionGET;
import pl.edu.pg.eti.id_191684.orchestra.entity.Section;

import java.util.function.Function;

@Component
public class SectionToDTOConverter implements Function<Section, SectionGET> {

    @Override
    public SectionGET apply(Section Section) {
        return SectionGET.builder()
                .id(Section.getId())
                .name(Section.getName())
                .location(Section.getLocation())
                .volume(Section.getVolume())
                .build();
    }
}
