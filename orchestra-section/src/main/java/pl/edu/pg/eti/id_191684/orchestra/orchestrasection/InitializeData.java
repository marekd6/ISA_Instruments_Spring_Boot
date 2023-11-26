package pl.edu.pg.eti.id_191684.orchestra.orchestrasection;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.pg.eti.id_191684.orchestra.orchestrasection.service.SectionService;
import pl.edu.pg.eti.id_191684.orchestra.orchestrasection.entity.Section;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Listener started automatically on Spring application context initialized. When using persistence storage application
 * instance should be initialized only during first run in order to init database with starting data. Good place to
 * create first default admin Section.
 */
@Component
public class InitializeData implements InitializingBean {


    /**
     * Service for Sections operations.
     */
    private final SectionService sectionService;


    /**
     * @param sectionService service for managing Sections
     */
    @Autowired
    public InitializeData(SectionService sectionService) {
        this.sectionService = sectionService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (sectionService.getAllSections().get().isEmpty()) {
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

/*            sectionService.saveSection(stringed);
            sectionService.saveSection(wind);
            sectionService.saveSection(percussion);
            sectionService.saveSection(electronic);*/

            sectionService.saveSection2(stringed);
            sectionService.saveSection2(wind);
            sectionService.saveSection2(percussion);
            sectionService.saveSection2(electronic);
        }
    }

}
