package com.app.marvel.service.impl;


import com.app.marvel.dto.MyPageableDto;
import com.app.marvel.persistence.integration.marvel.dto.CharacterDto;
import com.app.marvel.persistence.integration.marvel.repository.CharacterRepository;
import com.app.marvel.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterServiceImpl implements CharacterService {
    @Autowired
    private CharacterRepository characterRepository;

    @Override
    public List<CharacterDto> findAllCharacter(String name, int[] series, int[] events, int[] stories, MyPageableDto pagination) {

        return characterRepository.findAllCharacter(name, series, events, series, pagination);
    }

    @Override
    public CharacterDto findCharacterById(String id) {
        return characterRepository.findCharacterById(id);

    }

}
