package com.app.marvel.service;

import com.app.marvel.dto.MyPageableDto;
import com.app.marvel.persistence.integration.marvel.dto.ComicDto;

import java.util.List;

public interface CommicService {
    List<ComicDto> findAllComic(String title, int[] series, int[] events, int[] stories, MyPageableDto page);

    ComicDto findByComicId(Long id);
}
