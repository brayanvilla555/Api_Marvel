package com.app.marvel.persistence.integration.marvel.mapper;

import com.app.marvel.persistence.integration.marvel.dto.ComicDto;
import com.app.marvel.persistence.integration.marvel.dto.ThumbnailDto;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.util.ArrayList;
import java.util.List;

public class ComicMapper {
    public static List<ComicDto> toDoList(JsonNode response){
        JsonNode dataNode = getResultsNode(response);

        List<ComicDto> comics = new ArrayList<>();
        dataNode.forEach(each -> {
            comics.add(toComicDto(each));
        });
        return comics;
    }

    public static ComicDto toComicDto(JsonNode response){
        if(response == null){
            throw new IllegalArgumentException("El nodo Json no puede ser null");
        }
        ComicDto comicDto = new ComicDto();

        ThumbnailDto thumbnailDto = ThumbnailMapper.toDto(response.get("thumbnail"));

        return comicDto.builder()
                .id(response.get("id").asInt())
                .title(response.get("title").asText())
                .description(response.get("description").asText())
                .modified(response.get("modified").asText())
                .resourceURI(response.get("resourceURI").asText())
                .thumbnail(thumbnailDto)
                .build();

    }

    private static ArrayNode getResultsNode(JsonNode rootNode){
        if(rootNode == null){
            throw new IllegalArgumentException("El nodo json no puede ser null, class ComicMapper");
        }

        JsonNode dataNode = rootNode.get("data");
        return  (ArrayNode) dataNode.get("results");
    }
}
