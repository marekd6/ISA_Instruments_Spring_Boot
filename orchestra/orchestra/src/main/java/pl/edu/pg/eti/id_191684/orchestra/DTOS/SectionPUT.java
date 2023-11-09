package pl.edu.pg.eti.id_191684.orchestra.DTOS;

import lombok.*;


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
