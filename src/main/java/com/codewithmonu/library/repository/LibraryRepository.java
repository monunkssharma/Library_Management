package com.codewithmonu.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithmonu.library.entities.Library;

public interface LibraryRepository extends JpaRepository<Library, Integer>{

}
