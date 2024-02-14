package pl.edu.pg.eti.id_191684.orchestra.orchestrainstrument.converter;

import org.springframework.stereotype.Component;
import pl.edu.pg.eti.id_191684.orchestra.orchestrainstrument.DTOS.SectionGET;
import pl.edu.pg.eti.id_191684.orchestra.orchestrainstrument.entity.Section;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class SectionFromDTOConverter implements BiFunction<UUID, SectionGET, Section> {
    @Override
    public Section apply(UUID id, SectionGET dto) {
        return Section.builder()
                .id(id)
                .name(dto.getName())
                .build();
    }
}
