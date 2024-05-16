package com.app.marvel.persistence.integration.marvel.repository;

import com.app.marvel.dto.MyPageableDto;
import com.app.marvel.persistence.integration.marvel.MarvelApiConfig;
import com.app.marvel.persistence.integration.marvel.dto.ComicDto;
import com.app.marvel.persistence.integration.marvel.mapper.ComicMapper;
import com.app.marvel.service.HttpClientService;
import com.fasterxml.jackson.databind.JsonNode;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Repository
public class ComicRepository {

    @Autowired
    private HttpClientService httpClientService;

    @Autowired
    private MarvelApiConfig marvelApiConfig;

    @Value("http://gateway.marvel.com/v1/public")
    private String basePath;

    private String comicBasePath;

    @PostConstruct
    public void init(){
        comicBasePath = basePath.concat("/").concat("comics");
    }

    public List<ComicDto> findAllComic(String title, int[] series, int[] events, int[] stories, MyPageableDto page) {
        Map<String, String> comicQueryParams = getQueryParamsAllFindByAll(title,series, events, stories, page);

        JsonNode response = httpClientService.doGet(comicBasePath, comicQueryParams, JsonNode.class);

        return ComicMapper.toDoList(response);
    }

    private Map<String, String> getQueryParamsAllFindByAll(String title, int[] series, int[] events, int[] stories, MyPageableDto page) {
        Map<String, String> comicQueryParams = marvelApiConfig.getAuthenticationQueryParams();

        comicQueryParams.put("offset", String.valueOf(page.offset()));
        comicQueryParams.put("limit", String.valueOf(page.limit()));
        if(title != null){
            comicQueryParams.put("title", title);
        }

        if (series != null) {
            comicQueryParams.put("series",toStringOfArray(series));
        }

        if (events != null) {
            comicQueryParams.put("events",toStringOfArray(events));
        }

        if (stories != null) {
            comicQueryParams.put("events",toStringOfArray(stories));
        }

        return comicQueryParams;
    }

    private String toStringOfArray(int[] array){
        List<String> lista = Arrays.asList(Arrays.toString(array));
        return String.join(",", lista);
    }


    public ComicDto findByComicId(Long id) {
        Map<String, String> comicQueryParams = marvelApiConfig.getAuthenticationQueryParams();
        String endpoind = comicBasePath.concat("/").concat(id.toString());

        JsonNode response = httpClientService.doGet(endpoind, comicQueryParams, JsonNode.class);

        return ComicMapper.toDoList(response).get(0);
    }
}
