package com.example.datahubteste.repository;

import com.example.datahubteste.model.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface WordRepository extends JpaRepository<Word, Long> {
}
