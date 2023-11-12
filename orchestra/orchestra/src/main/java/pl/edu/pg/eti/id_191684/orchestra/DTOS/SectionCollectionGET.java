package pl.edu.pg.eti.id_191684.orchestra.DTOS;

import lombok.*;

import java.util.List;
import java.util.UUID;

/**
* DTO for reading collection of Sections
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
@ToString
public class SectionCollectionGET {

    private final String description = "Collection of Sections";

    /**
    * list of ids
     */
    private List<UUID> sections;

}
