package com.example.datahubteste.service;

import com.example.datahubteste.ApplicationConfigTest;
import com.example.datahubteste.model.Word;
import com.example.datahubteste.repository.WordRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

@DisplayName("WordServiceTest")
public class WordServiceTest extends ApplicationConfigTest {

    @MockBean
    private WordRepository repo;

    @Autowired
    private WordService service;

    @Test
    @DisplayName("Deve retornar todas as words registradas no banco")
    public void deve_retornar_todas_as_words() {
        List<Word> records = new ArrayList<>();

        Mockito.when(repo.findAll()).thenReturn(records);

        service.findAll();
    }
}
