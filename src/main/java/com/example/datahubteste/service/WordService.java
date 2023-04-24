package com.example.datahubteste.service;

import com.example.datahubteste.model.Word;
import com.example.datahubteste.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class WordService {

    private final WordRepository repo;

    @Autowired
    public WordService(WordRepository repo) {
        this.repo = repo;
    }

    public List<Word> findAll() {
        List<Word> records = repo.findAll();
        return records;
    }

    public Word findById(Long id) throws Throwable {
        Optional<Word> record = repo.findById(id);
        return record.orElseThrow(null);
    }

    public Word save(Word word) {
        Word record = repo.save(word);
        return record;
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public String invertWord(String word) {
        StringBuilder stringBuilder = new StringBuilder((CharSequence) word);
        String reverseWord = stringBuilder.reverse().toString();
        return reverseWord;
    }
}
