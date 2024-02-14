package pl.edu.pg.eti.id_191684.orchestra.orchestrainstrument.converter;

import org.springframework.stereotype.Component;
import pl.edu.pg.eti.id_191684.orchestra.orchestrainstrument.DTOS.InstrumentCollectionGET;
import pl.edu.pg.eti.id_191684.orchestra.orchestrainstrument.entity.Instrument;

import java.util.List;
import java.util.UUID;
import java.util.function.Function;

@Component
public class InstrumentCollectionToDTOConverter implements Function<List<Instrument>, InstrumentCollectionGET> {

    @Override
    public InstrumentCollectionGET apply(List<Instrument> instruments) {

        return InstrumentCollectionGET.builder()
                .description("Collection of Instruments")
                .instruments(instruments.stream()
                        .map(instrument -> InstrumentCollectionGET.Instrument.builder()
                                .id(instrument.getId())
                                .name(instrument.getName())
                                .build())
                        .toList())
                .build();

/*        List<UUID> uuids = instruments.stream()
                .map(instrument -> instrument.getId())
                .toList();
        return InstrumentCollectionGET.builder()
                .description("Collection of Instruments (ids)")
                .instruments(uuids)
                .build();*/
    }
}
