package pl.edu.pg.eti.id_191684.orchestra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pg.eti.id_191684.orchestra.entity.Instrument;
import pl.edu.pg.eti.id_191684.orchestra.entity.Section;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface InstrumentRepository extends JpaRepository<Instrument, UUID> {
    List<Instrument> findAllBySection(Section section);

    Optional<Instrument> findByIdAndSection(UUID id, Section section);
}

