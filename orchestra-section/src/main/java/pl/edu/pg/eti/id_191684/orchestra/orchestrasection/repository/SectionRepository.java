package pl.edu.pg.eti.id_191684.orchestra.orchestrasection.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pg.eti.id_191684.orchestra.orchestrasection.entity.Section;

import java.util.UUID;

@Repository
public interface SectionRepository extends JpaRepository<Section, UUID> {
}

