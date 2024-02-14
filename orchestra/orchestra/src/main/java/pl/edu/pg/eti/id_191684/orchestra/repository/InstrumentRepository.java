package pl.edu.pg.eti.id_191684.orchestra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pg.eti.id_191684.orchestra.entity.Instrument;

import java.util.List;
import java.util.UUID;

@Repository
public interface InstrumentRepository extends JpaRepository<Instrument, UUID> {
    List<Instrument> findBySectionId(UUID sectionId);
}

