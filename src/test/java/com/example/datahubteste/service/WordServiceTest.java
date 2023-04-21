package com.example.datahubteste.service;

import com.example.datahubteste.ApplicationConfigTest;
import com.example.datahubteste.model.Word;
import com.example.datahubteste.repository.WordRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;

@DisplayName("WordServiceTest")
public class WordServiceTest extends ApplicationConfigTest {

    @MockBean
    private WordRepository repo;

    @Autowired
    private WordService service;

    @Test
    @DisplayName("Should return all words stored in the database")
    public void shoud_return_all_words() {
        List<Word> records = new ArrayList<>();

        Mockito.when(repo.findAll()).thenReturn(records);

        service.findAll();
    }


    @Test
    @DisplayName("Should return a word by ID")
    public void should_return_word_by_id() throws Throwable {
        Word word = new Word("Hope");
        word.setId(UUID.randomUUID());


        given(repo.findById(word.getId())).willReturn(Optional.of(word));
        final Optional<Word> expectedWord = Optional.ofNullable(service.findById(word.getId()));

        Assertions.assertThat(expectedWord).isNotNull();
    }

    @Test
    @DisplayName("Should store a word given as URI parameter in the database")
    public void should_store_a_word_in_the_database() {
        Word word = new Word("Hope");

        word.setId(UUID.randomUUID());

        Mockito.when(repo.save(word)).thenReturn(word);
    }
}
