package pl.edu.pg.eti.id_191684.orchestra.converter;

import org.springframework.stereotype.Component;
import pl.edu.pg.eti.id_191684.orchestra.DTOS.InstrumentCollectionGET;
import pl.edu.pg.eti.id_191684.orchestra.entity.Instrument;

import java.util.List;
import java.util.UUID;
import java.util.function.Function;

@Component
public class InstrumentCollectionToDTOConverter implements Function<List<Instrument>, InstrumentCollectionGET> {

    @Override
    public InstrumentCollectionGET apply(List<Instrument> instruments) {
        List<UUID> uuids = instruments.stream()
                .map(instrument -> instrument.getId())
                .toList();
        return InstrumentCollectionGET.builder()
                .description("Collection of Instruments (ids)")
                .instruments(uuids)
                .build();
    }
}
