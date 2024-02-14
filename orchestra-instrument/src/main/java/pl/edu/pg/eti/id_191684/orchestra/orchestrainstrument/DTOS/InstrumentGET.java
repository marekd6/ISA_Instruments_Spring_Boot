package pl.edu.pg.eti.id_191684.orchestra.orchestrainstrument.DTOS;


import lombok.*;

import java.util.UUID;

/**
* A DTO for Instrument to handle GET requests
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class InstrumentGET {

    /**
    * Section for the DTO
     */
    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @ToString
    @EqualsAndHashCode
    public static class Section{
        private UUID id;
        private String name;
    }

    private UUID id;

    private String name;

    private int production_year;

    private Section section;

}
