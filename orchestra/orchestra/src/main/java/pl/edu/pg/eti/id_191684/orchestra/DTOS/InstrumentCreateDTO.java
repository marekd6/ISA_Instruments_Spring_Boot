package pl.edu.pg.eti.id_191684.orchestra.DTOS;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InstrumentCreateDTO {
    private String name;
    private UUID sectionId;

    // Constructors, getters, and setters
}
