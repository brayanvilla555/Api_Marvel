package com.app.marvel.persistence.integration.marvel.mapper;

import com.app.marvel.persistence.integration.marvel.dto.CharacterDto;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CharacterMapper {
    public static List<CharacterDto> toDoList(JsonNode reponses) {

        ArrayNode arrayNode = getResultsNode(reponses);

        List<CharacterDto> characters = new ArrayList<>();
        arrayNode.elements().forEachRemaining( response ->{
            characters.add(toCharacterDto(response));
        } );
        return characters;
    }

    public static  CharacterDto toCharacterDto(JsonNode characterNode){
        if(characterNode == null ){
            throw new IllegalArgumentException("El nodo Json no puede ser null");
        }

        CharacterDto characterDto = new CharacterDto();
        return characterDto.builder()
                .id(Long.parseLong(characterNode.get("id").asText()))
                .name(characterNode.get("name").asText())
                .description(characterNode.get("description").asText())
                .modified(characterNode.get("modified").asText())
                .resourceURI(characterNode.get("resourceURI").asText())
                .build();
    }

    private static ArrayNode getResultsNode (JsonNode rootNode){
        if(rootNode == null ){
            throw new IllegalArgumentException("El nodo Json de Charactes no puede ser null");
        }
        JsonNode dataNode = rootNode.get("data");
        return  (ArrayNode)dataNode.get("results");
    }
}
