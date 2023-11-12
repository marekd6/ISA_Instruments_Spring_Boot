package pl.edu.pg.eti.id_191684.orchestra.DTOS;

import lombok.*;

import java.util.UUID;

/**
 * A DTO for Section to handle GET requests
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class SectionGET {

    private UUID id;

    private String name;

    private int volume;

    private int location;

}
