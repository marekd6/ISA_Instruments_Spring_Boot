package pl.edu.pg.eti.id_191684.orchestra.orchestrasection.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import static java.util.Objects.hash;

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

    @OneToMany(mappedBy = "section", cascade = CascadeType.REMOVE)
    private List<Instrument> instrumentList; // final removed

    @PrePersist
    void generateUUID() {
        if (this.id == null) { // key change lvl 2
            int hashCode = hash(name, volume, location);
            long mostSigBits = (long) hashCode << 32;
            long leastSigBits = hashCode & 0xFFFFFFFFL;
            id = new UUID(mostSigBits, leastSigBits);
        }
    }

    @Override
    public int hashCode() {
        return hash(name, volume, location, id);
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
