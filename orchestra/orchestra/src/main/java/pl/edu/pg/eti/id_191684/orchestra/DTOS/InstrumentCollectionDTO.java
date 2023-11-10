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
public class InstrumentCollectionDTO {

    /*
    list of ids
     */
    private List<UUID> instruments;

    @Override
    public String toString(){
        return "Collection of Instruments: " + instruments.toString();
    }

}
