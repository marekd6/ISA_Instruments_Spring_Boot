package pl.edu.pg.eti.id_191684.orchestra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.pg.eti.id_191684.orchestra.entity.*;
import pl.edu.pg.eti.id_191684.orchestra.service.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@Component
public class DataInitializer {

    private final InstrumentService instrumentService;
    private final SectionService sectionService;

    @Autowired
    public DataInitializer(InstrumentService instrumentService, SectionService sectionService) {
        this.instrumentService = instrumentService;
        this.sectionService = sectionService;
    }

    @PostConstruct
    public void initData() {
        // sections:
        Section stringed = Section.builder()
                .name("String")
                .volume(5)
                .location(1)
                .instrumentList(new ArrayList<>())
                .build();
        Section wind = Section.builder()
                .name("Wind")
                .volume(8)
                .location(2)
                .instrumentList(new ArrayList<>())
                .build();
        Section percussion = Section.builder()
                .name("Percussion")
                .volume(10)
                .location(3)
                .instrumentList(new ArrayList<>())
                .build();
        Section electronic = Section.builder()
                .name("Electronic")
                .volume(5)
                .location(4)
                .instrumentList(new ArrayList<>())
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
