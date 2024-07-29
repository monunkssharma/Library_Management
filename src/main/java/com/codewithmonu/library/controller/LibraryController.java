package com.codewithmonu.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithmonu.library.entities.Book;
import com.codewithmonu.library.entities.Library;
import com.codewithmonu.library.service.LibraryService;

@RestController
@RequestMapping("/api/libraries")
public class LibraryController {
	@Autowired
	private LibraryService libraryService;
	
	@PostMapping
	public Library createLibrary (@RequestBody Library library) {
		return libraryService.createLibrary(library);
		
	}
	@DeleteMapping("/{libraryId}/books/{bookId}")
	public Library addBooktoLibrary(@PathVariable Integer libraryId, @PathVariable Integer bookId) {
		return libraryService.deleteBookFromLibrary(libraryId, bookId);
	}
	
	@PatchMapping("/books/{bookId}")
	public Book assignBookToStudent(@PathVariable Integer bookId, @RequestBody String studentName) {
		return libraryService.assignBooktoStudent(bookId, studentName);
	}

}
