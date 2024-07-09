package com.example.sealibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.sealibrary.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
