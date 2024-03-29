package pl.edu.pg.eti.id_191684.orchestra.orchestrasection.converter;

import org.springframework.stereotype.Component;
import pl.edu.pg.eti.id_191684.orchestra.orchestrasection.DTOS.SectionPUT;
import pl.edu.pg.eti.id_191684.orchestra.orchestrasection.entity.Section;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class SectionFromDTOConverter implements BiFunction<UUID, SectionPUT, Section> {
    @Override
    public Section apply(UUID id, SectionPUT dto) {
        return Section.builder()
                .id(id)
                .name(dto.getName())
                .volume(dto.getVolume())
                .location(dto.getLocation())
                .build();
    }
}
