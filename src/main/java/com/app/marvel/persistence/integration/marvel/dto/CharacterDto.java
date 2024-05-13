package com.app.marvel.persistence.integration.marvel.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CharacterDto {
    private long id;
    private String name;
    private String description;
    private String modified;
    private String resourceURI ;

}
