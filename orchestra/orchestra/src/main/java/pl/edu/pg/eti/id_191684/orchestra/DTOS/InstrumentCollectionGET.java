package pl.edu.pg.eti.id_191684.orchestra.DTOS;

import lombok.*;

import java.util.List;
import java.util.UUID;

/**
* DTO for reading collection of Instruments
*/
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
@ToString
public class InstrumentCollectionGET {

    private String description;

    /**
     * list of ids
     */
    private List<UUID> instruments;


}
