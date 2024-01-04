package pl.edu.pg.eti.id_191684.orchestra.orchestrainstrument;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.pg.eti.id_191684.orchestra.orchestrainstrument.entity.Instrument;
import pl.edu.pg.eti.id_191684.orchestra.orchestrainstrument.entity.Section;
import pl.edu.pg.eti.id_191684.orchestra.orchestrainstrument.service.InstrumentService;
import pl.edu.pg.eti.id_191684.orchestra.orchestrainstrument.service.SectionService;

import java.util.ArrayList;
import java.util.UUID;

@Component
public class InitializeData implements InitializingBean {

    /**
     * Service for characters operations.
     */
    private final InstrumentService instrumentService;

    /**
     * Service for users operations.
     */
    private final SectionService sectionService;
    

    /**
     * @param instrumentService  service for managing characters
     * @param sectionService       service for managing users
     */
    @Autowired
    public InitializeData(
            InstrumentService instrumentService,
            SectionService sectionService
    ) {
        this.instrumentService = instrumentService;
        this.sectionService = sectionService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (instrumentService.getAllInstruments().get().isEmpty()) {
            // sections:
            Section stringed = Section.builder()
                    .id(UUID.fromString("6ed878ec-0000-0000-0000-00006ed878ec"))
                    .name("String")
                    .instrumentList(new ArrayList<>())
                    .build();
            Section wind = Section.builder()
                    .id(UUID.fromString("9a712f81-0000-0000-0000-00009a712f81"))
                    .name("Wind")
                    .build();
            Section percussion = Section.builder()
                    .id(UUID.fromString("4c791c31-0000-0000-0000-00004c791c31"))
                    .name("Percussion")
                    .build();
            Section electronic = Section.builder()
                    .id(UUID.fromString("ff05ec9a-0000-0000-0000-0000ff05ec9a"))
                    .name("Electronic")
                    .build();

            sectionService.saveSection(stringed);
            sectionService.saveSection(wind);
            sectionService.saveSection(percussion);
            sectionService.saveSection(electronic);

            // instruments:
            Instrument violin = new Instrument("violin", 1850, stringed);
            Instrument viola = new Instrument("viola", 1850, stringed);
            Instrument cello = new Instrument("cello", 1890, stringed);
            Instrument horn = new Instrument("horn", 1870, wind);
            Instrument flute = new Instrument("flute", 1850, wind);
            Instrument gong = new Instrument("gong", 1940, percussion);

            // Save Instruments
            instrumentService.saveInstrument(violin);
            instrumentService.saveInstrument(viola);
            instrumentService.saveInstrument(cello);
            instrumentService.saveInstrument(horn);
            instrumentService.saveInstrument(flute);
            instrumentService.saveInstrument(gong);
        }
    }


}
