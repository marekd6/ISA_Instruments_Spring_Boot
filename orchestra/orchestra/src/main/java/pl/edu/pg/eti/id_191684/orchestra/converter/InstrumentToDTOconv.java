package pl.edu.pg.eti.id_191684.orchestra.converter;

import pl.edu.pg.eti.id_191684.orchestra.DTOS.InstrumentDTO;
import pl.edu.pg.eti.id_191684.orchestra.entity.Instrument;

import java.util.List;
import java.util.function.Function;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class InstrumentToDTOconv implements Function<Instrument, InstrumentDTO> {

    @Override
    public InstrumentDTO apply(Instrument instrument) {
        return InstrumentDTO.builder()
                .id(instrument.getId())
                .name(instrument.getName())
                .production_year(instrument.getProduction_year())
                .section(InstrumentDTO.Section.builder()
                        .id(instrument.getSection().getId())
                        .name(instrument.getSection().getName())
                        .build())
                .build();
    }
}
