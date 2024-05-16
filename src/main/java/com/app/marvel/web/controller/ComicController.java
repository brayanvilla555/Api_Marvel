package com.app.marvel.web.controller;

import com.app.marvel.dto.MyPageableDto;
import com.app.marvel.persistence.integration.marvel.dto.ComicDto;
import com.app.marvel.service.CommicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("comic")
public class ComicController {

    @Autowired
    private CommicService commicService;

    @GetMapping("/")
    public ResponseEntity<List<ComicDto>> getComic(@RequestParam(required = false) String title,
                                         @RequestParam(required = false) int[] series,
                                         @RequestParam(required = false) int[] events,
                                         @RequestParam(required = false) int[] stories,
                                         @RequestParam(defaultValue = "10") int limit,
                                         @RequestParam(defaultValue = "0") int offset
    ) {
        MyPageableDto page = new MyPageableDto(limit, offset);
        return ResponseEntity.ok(commicService.findAllComic(title, series, events, stories, page));
    }

    @GetMapping("/{comicId}")
    public ResponseEntity<ComicDto> getComic(@PathVariable Long comicId) {
        return ResponseEntity.ok(commicService.findByComicId(comicId));
    }
}
