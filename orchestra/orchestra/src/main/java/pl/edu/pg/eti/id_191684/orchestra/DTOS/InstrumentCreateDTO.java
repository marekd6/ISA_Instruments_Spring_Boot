package pl.edu.pg.eti.id_191684.orchestra.DTOS;


import lombok.*;

import java.util.UUID;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class InstrumentCreateDTO {

    private String name;

    private int production_year;

    private UUID section;

}
