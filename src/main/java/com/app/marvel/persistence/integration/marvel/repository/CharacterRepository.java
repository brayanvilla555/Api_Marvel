package com.app.marvel.persistence.integration.marvel.repository;

import com.app.marvel.dto.Pagination;
import com.app.marvel.persistence.integration.marvel.ConfigIntegrationApi;
import com.app.marvel.persistence.integration.marvel.dto.CharacterDto;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Repository
public class CharacterRepository {

    @Autowired
    private ConfigIntegrationApi configIntegrationApi;

    @Value("${integration.api.marvel.base-path}")
    private String basePath;

    private String characterBasePath;

    @PostConstruct
    public void init() {
        characterBasePath = basePath.concat("/").concat("characters");
    }

    public List<CharacterDto> findAllCharacter(String name, int[] series, int[] events, int[] stories, Pagination pagination) {
        return null;
    }

    private String toStringOfArray(int[] array){
        List<String> strigArray = IntStream.of(array).boxed()
                        .map( element -> element.toString())
                        .collect(Collectors.toList());
        return String.join(",", strigArray);
    }


}
