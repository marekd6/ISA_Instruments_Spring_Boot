package pl.edu.pg.eti.id_191684.orchestra.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import static java.util.Objects.hash;

/**
 * An instrument belonging to a section
 */
@Getter
@Setter
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Builder
@Entity
@Table(name = "instruments")
public class Instrument implements Comparable<Instrument>, Serializable {

    @Id
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private UUID id;

    @Column(name = "name")
    private final String name;

    @Column(name = "production_year")
    private final int production_year;

    @ManyToOne
    @JoinColumn(name = "section")
    private final Section section;

    public Instrument(String name, int production_year, Section section) {
        this.name = name;
        this.section = section;
        this.production_year = production_year;
    }

    @PrePersist
    void generateUUID(){
        int hashCode = hash(name, production_year, section);
        long mostSigBits = (long) hashCode << 32;
        long leastSigBits = hashCode & 0xFFFFFFFFL;
        id = new UUID(mostSigBits, leastSigBits);
    }

    @Override
    public int compareTo(Instrument o) {
        int comp = name == null
                ? (o.name == null ? 0 : 1)
                : name.compareTo(o.name);
        if (comp == 0) {
            comp = section == null
                    ? (o.section == null ? 0 : 1)
                    : section.compareTo(o.section);
        }
        if (comp == 0) {
            comp = production_year - o.production_year;
        }
        return comp;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, section, production_year, id);
    }

    @Override
    public String toString() {
        return "Instrument: " + name + ", from year " + production_year + ", in: " + section.getName() + ". ID: " + id;
    }
}
