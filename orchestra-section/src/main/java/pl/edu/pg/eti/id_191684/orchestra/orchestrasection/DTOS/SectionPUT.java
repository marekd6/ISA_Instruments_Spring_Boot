package pl.edu.pg.eti.id_191684.orchestra.orchestrasection.DTOS;

import lombok.*;


/**
 * A DTO for Section to handle PUT requests
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class SectionPUT {

    private String name;

    private int volume;

    private int location;

}
