package com.example.datahubteste.controller;

import com.example.datahubteste.model.Word;
import com.example.datahubteste.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/")
public class WordController {

    @Autowired
    private WordService service;

    @PostMapping("")
    public Word word(@RequestBody Word word) {
        Word record = service.save(word);
        String invertedWord = service.invertWord(word.getWord());
        return new Word(invertedWord);
    }


    @GetMapping("/")
    public ResponseEntity<List<Word>> getAll() {
        List<Word> records = service.findAll();
        return new ResponseEntity<>(records, HttpStatus.OK);
    }

//    @PostMapping("/{word}")
//    public ResponseEntity<Word> insert(@RequestBody Word word) {
//        Word record = service.save(word);
//        return new ResponseEntity<>(record, HttpStatus.CREATED);
//    }
}
