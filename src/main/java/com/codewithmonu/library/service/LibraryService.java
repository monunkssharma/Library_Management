package com.codewithmonu.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithmonu.library.entities.Book;
import com.codewithmonu.library.entities.Library;
import com.codewithmonu.library.repository.BookRepository;
import com.codewithmonu.library.repository.LibraryRepository;

@Service
public class LibraryService {
	@Autowired
	private LibraryRepository libraryRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	//createLibrary
	public Library createLibrary(Library library) {
		return libraryRepository.save(library);
	}

	//addBookToLibrary
	public Library addBookToLibrary(Integer libraryId, Book book) {
		Library library=libraryRepository.findById(libraryId).orElseThrow();
		book.setLibrary(library);
		bookRepository.save(book);
		library.getBooks().add(book);
		return libraryRepository.save(library);
	}
	
	//deleteBookFromLibrary
	public Library deleteBookFromLibrary(Integer libraryId, Integer bookId) {
		Library library=libraryRepository.findById(libraryId).orElseThrow();
		Book book=bookRepository.findById(bookId).orElseThrow();
		library.getBooks().remove(book);
		bookRepository.delete(book);
		return libraryRepository.save(library);	
	}
	
	//assignBookto Student
	public Book assignBooktoStudent(Integer bookId, String studentName) {
		Book book = bookRepository.findById(bookId).orElseThrow();
		book.setAuthor(studentName);
		return bookRepository.save(book);
		
	}
	
}
