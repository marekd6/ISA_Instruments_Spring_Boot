package pl.edu.pg.eti.id_191684.orchestra.orchestrainstrument.DTOS;

import lombok.*;

/**
* A DTO for Instrument to handle PUT requests
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class InstrumentPUT {

    private String name;

    private int production_year;

}
