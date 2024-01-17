package pl.edu.pg.eti.id_191684.orchestra.orchestrainstrument.DTOS;

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

    /**
     * An Instrument in a list.
     */
    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @ToString
    @EqualsAndHashCode
    public static class Instrument {

        /**
         * Instrument's ID
         */
        private UUID id;

        /**
         * Name of the Instrument.
         */
        private String name;

    }

    /**
     * Description of a collection
     */
    private String description;

    /**
     * list of ids
     */
//    private List<UUID> instruments;

    /**
     * list of Instruments
     */
    private List<Instrument> instruments;


}
