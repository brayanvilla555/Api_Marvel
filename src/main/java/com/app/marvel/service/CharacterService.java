package com.app.marvel.service;

import com.app.marvel.persistence.integration.marvel.dto.CharacterDto;
import com.app.marvel.dto.Pagination;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CharacterService {
    List<CharacterDto> findAllCharacter(String name, int[] series, int[] events, int[] stories, Pagination pagination);
}
