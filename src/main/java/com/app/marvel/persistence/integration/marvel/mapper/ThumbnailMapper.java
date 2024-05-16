package com.app.marvel.persistence.integration.marvel.mapper;

import com.app.marvel.persistence.integration.marvel.dto.ThumbnailDto;
import com.fasterxml.jackson.databind.JsonNode;

public class ThumbnailMapper {

    public static ThumbnailDto toDto(JsonNode thumbnail) {
        if (thumbnail.isNull()) {
            throw new IllegalArgumentException("Thumbnail is null");
        }
        ThumbnailDto thumbnailDto = new ThumbnailDto();

        return thumbnailDto.builder()
                .path(thumbnail.get("path").asText())
                .extension(thumbnail.get("extension").asText())
                .build();
    }
}
