package com.app.marvel.persistence.integration.marvel.repository;

import com.app.marvel.dto.MyPageableDto;
import com.app.marvel.persistence.integration.marvel.MarvelApiConfig;
import com.app.marvel.persistence.integration.marvel.dto.CharacterDto;
import com.app.marvel.persistence.integration.marvel.mapper.CharacterMapper;
import com.app.marvel.service.HttpClientService;
import com.fasterxml.jackson.databind.JsonNode;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Repository
public class CharacterRepository {

    @Autowired
    private MarvelApiConfig marvelApiConfig;

    @Autowired
    private HttpClientService httpClientService;

    @Value("${integration.api.marvel.base-path}")
    private String basePath;

    private String characterBasePath;

    @PostConstruct
    public void init() {
        characterBasePath = basePath.concat("/").concat("characters");
    }

    public List<CharacterDto> findAllCharacter(String name, int[] series, int[] events, int[] stories, MyPageableDto pagination) {

        Map<String, String> marvelQueryParamts  = getQueryParamsForFindAll(name, series, events, stories, pagination) ;

        JsonNode reponse = httpClientService.doGet(characterBasePath, marvelQueryParamts, JsonNode.class);

        return CharacterMapper.toDoList(reponse);
    }

    public CharacterDto findCharacterById(String id) {
        Map<String, String> marvelQueryParams = marvelApiConfig.getAuthenticationQueryParams();

        String finalUrl = characterBasePath.concat("/").concat(id);

        JsonNode jsonNode = httpClientService.doGet(finalUrl, marvelQueryParams ,JsonNode.class);

        return CharacterMapper.toDoList(jsonNode).get(0);

    }

    private Map<String, String> getQueryParamsForFindAll(String name, int[] series, int[] events, int[] stories, MyPageableDto pagination) {
        Map<String, String> marvelQueryParams = marvelApiConfig.getAuthenticationQueryParams();
        marvelQueryParams.put("offset", String.valueOf(pagination.offset()));
        marvelQueryParams.put("limit", String.valueOf(pagination.limit()));

        if(series != null){
            marvelQueryParams.put("series", String.valueOf(series));
        }

        if (events != null){
            marvelQueryParams.put("events",toStringOfArray(events));
        }

        if(events != null){
            marvelQueryParams.put("stories", toStringOfArray(stories));
        }
        return marvelQueryParams;
    }

    private String toStringOfArray(int[] array){
        List<String> strigArray = IntStream.of(array).boxed()
                        .map( element -> element.toString())
                        .collect(Collectors.toList());
        return String.join(",", strigArray);
    }


}
