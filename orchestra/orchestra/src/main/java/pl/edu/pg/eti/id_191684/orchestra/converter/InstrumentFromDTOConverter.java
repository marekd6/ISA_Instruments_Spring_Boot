package pl.edu.pg.eti.id_191684.orchestra.converter;

import org.springframework.stereotype.Component;
import pl.edu.pg.eti.id_191684.orchestra.DTOS.InstrumentPUT;
import pl.edu.pg.eti.id_191684.orchestra.entity.Instrument;
import pl.edu.pg.eti.id_191684.orchestra.entity.Section;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class InstrumentFromDTOConverter implements BiFunction<UUID, InstrumentPUT, Instrument> {
    @Override
    public Instrument apply(UUID id, InstrumentPUT dto) {
        return Instrument.builder()
                .id(id)
                .name(dto.getName())
                .production_year(dto.getProduction_year())
                .section(Section.builder()
                        .id(dto.getSectionId())
                        .build())
                .build();
    }
}
