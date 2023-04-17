package com.example.datahubteste.service;

import com.example.datahubteste.model.Word;
import com.example.datahubteste.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WordService {

    private final WordRepository repo;

    @Autowired
    public WordService(WordRepository repo) {
        this.repo = repo;
    }

    public List<Word> findAll() {
        List<Word> records = repo.findAll();
        return record;
    }
}
