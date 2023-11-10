package pl.edu.pg.eti.id_191684.orchestra.converter;

import org.springframework.stereotype.Component;
import pl.edu.pg.eti.id_191684.orchestra.DTOS.InstrumentGET;
import pl.edu.pg.eti.id_191684.orchestra.entity.Instrument;

import java.util.function.Function;

@Component
public class InstrumentToDTOConverter implements Function<Instrument, InstrumentGET> {

    @Override
    public InstrumentGET apply(Instrument instrument) {
        return InstrumentGET.builder()
                .id(instrument.getId())
                .name(instrument.getName())
                .production_year(instrument.getProduction_year())
                .section(InstrumentGET.Section.builder()
                        .id(instrument.getSection().getId())
                        .name(instrument.getSection().getName())
                        .build())
                .build();
    }
}
