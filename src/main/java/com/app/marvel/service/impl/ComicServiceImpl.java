package com.app.marvel.service.impl;

import com.app.marvel.dto.MyPageableDto;
import com.app.marvel.persistence.integration.marvel.dto.ComicDto;
import com.app.marvel.persistence.integration.marvel.repository.ComicRepository;
import com.app.marvel.service.CommicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComicServiceImpl implements CommicService {

    @Autowired
    private ComicRepository comicRepository;

    @Override
    public List<ComicDto> findAllComic(String title, int[] series, int[] events, int[] stories, MyPageableDto page) {
        return comicRepository.findAllComic(title, series, events, stories, page);
    }

    @Override
    public ComicDto findByComicId(Long id) {
        if (id != null) {
            return comicRepository.findByComicId(id);
        }
        System.out.println("Error en el servicio del comic");
        return null;
    }
}
