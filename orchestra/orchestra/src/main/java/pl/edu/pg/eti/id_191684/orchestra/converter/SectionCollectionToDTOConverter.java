package pl.edu.pg.eti.id_191684.orchestra.converter;

import org.springframework.stereotype.Component;
import pl.edu.pg.eti.id_191684.orchestra.DTOS.SectionCollectionGET;
import pl.edu.pg.eti.id_191684.orchestra.entity.Section;

import java.util.List;
import java.util.UUID;
import java.util.function.Function;

@Component
public class SectionCollectionToDTOConverter implements Function<List<Section>, SectionCollectionGET> {

    @Override
    public SectionCollectionGET apply(List<Section> Sections) {
        List<UUID> uuids = Sections.stream()
                .map(Section -> Section.getId())
                .toList();
        return SectionCollectionGET.builder()
                .sections(uuids)
                .build();
    }
}
