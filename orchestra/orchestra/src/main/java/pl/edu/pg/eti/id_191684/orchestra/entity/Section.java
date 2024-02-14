package pl.edu.pg.eti.id_191684.orchestra.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * A category. Instruments belong to a section
 */

@Getter
@Setter
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "sections")
public class Section implements Comparable<Section>, Serializable {

    @Id
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private UUID id;

    @Column(name = "name")
    private final String name;

    @Column(name = "volume")
    private final int volume;

    @Column(name = "location")
    private final int location;

    @OneToMany(mappedBy = "section", cascade = CascadeType.ALL)
    private final List<Instrument> instrumentList;

    @PrePersist
    void generateUUID() {
        id = UUID.randomUUID();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, volume, location, id);
    }

    @Override
    public String toString() {
        return "Section: " + name + ", volume: " + volume + ", location: " + location + ". ID: " + id;
    }

    @Override
    public int compareTo(Section o) {
        int comp = name == null
                ? (o.name == null ? 0 : 1)
                : name.compareTo(o.name);
        if (comp == 0) {
            comp = location - o.location;
        }
        if (comp == 0) {
            comp = volume - o.volume;
        }
        return comp;
    }

}
