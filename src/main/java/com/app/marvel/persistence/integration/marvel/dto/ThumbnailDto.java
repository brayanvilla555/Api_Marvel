package com.app.marvel.persistence.integration.marvel.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ThumbnailDto {
    private String path;
    private String extension;
}
