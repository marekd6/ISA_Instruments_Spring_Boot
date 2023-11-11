package pl.edu.pg.eti.id_191684.orchestra.converter;

import org.antlr.v4.runtime.misc.Pair;
import org.springframework.stereotype.Component;
import pl.edu.pg.eti.id_191684.orchestra.DTOS.InstrumentPUT;
import pl.edu.pg.eti.id_191684.orchestra.entity.Instrument;
import pl.edu.pg.eti.id_191684.orchestra.entity.Section;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class InstrumentFromDTOConverter implements BiFunction<Pair<UUID, UUID>, InstrumentPUT, Instrument> {
    @Override
    public Instrument apply(Pair uuids, InstrumentPUT dto) {
        return Instrument.builder()
                .id((UUID) uuids.a)
                .name(dto.getName())
                .production_year(dto.getProduction_year())
                .section(Section.builder()
                        .id((UUID) uuids.b)
                        .build())
                .build();
    }
}
