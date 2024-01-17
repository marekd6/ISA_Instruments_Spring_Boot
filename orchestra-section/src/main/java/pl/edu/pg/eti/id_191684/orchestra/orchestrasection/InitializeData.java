package pl.edu.pg.eti.id_191684.orchestra.orchestrasection;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.pg.eti.id_191684.orchestra.orchestrasection.entity.Section;
import pl.edu.pg.eti.id_191684.orchestra.orchestrasection.service.SectionService;

import java.util.ArrayList;

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

            sectionService.saveSection2(stringed);
            sectionService.saveSection2(wind);
            sectionService.saveSection2(percussion);
            sectionService.saveSection2(electronic);
        }
    }

}
