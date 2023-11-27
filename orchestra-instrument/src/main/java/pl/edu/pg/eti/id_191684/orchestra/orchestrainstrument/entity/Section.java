package pl.edu.pg.eti.id_191684.orchestra.orchestrainstrument.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * Simplified version used in Instrument part
 * A category. Instruments belong to a section
 */
@Getter
@Setter
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "sections")
public class Section implements Serializable {

    @Id
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private UUID id;

    @Column(name = "name")
    String name;

    @OneToMany(mappedBy = "section", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private final List<Instrument> instrumentList;

}
