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
@RequestMapping("/word")
public class WordController {

    @Autowired
    private WordService service;

    @PostMapping("/save")
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

    @GetMapping("/{id}")
    public ResponseEntity<Word> getById(@PathVariable("id") String id) throws Throwable {
        Long longId = Long.parseLong(id);
        Word record = service.findById(longId);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Word> update(@RequestBody Word word) {
        Word record = service.save(word);
        return new ResponseEntity<>(record, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
