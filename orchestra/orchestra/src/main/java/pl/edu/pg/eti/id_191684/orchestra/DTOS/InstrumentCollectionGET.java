package pl.edu.pg.eti.id_191684.orchestra.DTOS;

import lombok.*;

import java.util.List;
import java.util.UUID;

/*
DTO for reading collection of Instruments
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
@ToString
public class InstrumentCollectionGET {

    private final String description = "Collection of Instruments";

    /*
    list of ids
     */
    private List<UUID> instruments;


}
