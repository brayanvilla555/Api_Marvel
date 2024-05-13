package com.app.marvel.web.controller;

import com.app.marvel.dto.MyPageableDto;
import com.app.marvel.persistence.integration.marvel.dto.CharacterDto;
import com.app.marvel.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/character")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @GetMapping("/")
    public ResponseEntity<List<CharacterDto>> findAllCharacter(@RequestParam(required = false) String name,
                                           @RequestParam(required = false) int[] series,
                                           @RequestParam(required = false) int[] events,
                                           @RequestParam(required = false) int[] stories,
                                           @RequestParam(defaultValue = "10") int limit,
                                           @RequestParam(defaultValue = "0") int offset){

        MyPageableDto pagination = new MyPageableDto(limit, offset);

        return ResponseEntity.ok(characterService.findAllCharacter(name, series, events, stories, pagination));

    }
}
