package pl.edu.pg.eti.id_191684.orchestra.orchestrainstrument.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pg.eti.id_191684.orchestra.orchestrainstrument.entity.Section;

import java.util.UUID;

@Repository
public interface SectionRepository extends JpaRepository<Section, UUID> {
}

