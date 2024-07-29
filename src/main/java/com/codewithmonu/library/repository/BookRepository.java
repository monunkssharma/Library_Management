package com.codewithmonu.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithmonu.library.entities.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
