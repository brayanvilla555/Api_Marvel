package com.app.marvel.persistence.integration.marvel.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ComicDto {
    private long id;
    private String title;
    private String description;
    private String modified;

    private String resourceURI;
    private ThumbnailDto thumbnail;
}
