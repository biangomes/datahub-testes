package com.example.datahubteste.controller;

import com.example.datahubteste.model.Word;
import com.example.datahubteste.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/")
public class WordController {

    @Autowired
    private WordService service;

    @PostMapping("/{word}")
    public ResponseEntity<Word> insert(@RequestBody Word word) {
        Word record = service.save(word);
        return new ResponseEntity<>(record, HttpStatus.CREATED);
    }
}
