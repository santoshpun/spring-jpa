package com.santosh.springjpa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.santosh.springjpa.model.Book;
import com.santosh.springjpa.repo.BookRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository bookRepository;

	@GetMapping("/")
	@ResponseBody
	public List<Book> getAllBooks() {
		List<Book> books = bookRepository.findAll();
		return books;
	}

	@GetMapping("/books/{id}")
	@ResponseBody
	public Book getBookById(@PathVariable("id") int id) {
		Optional<Book> book = bookRepository.findById(id);
		if (book.isPresent()) {
			Book bookObj = book.get();
			return bookObj;
		}
		return null;
	}

	@PostMapping("/books")
	@ResponseBody
	public Book save(@RequestBody Book book) {
		bookRepository.save(book);
		return book;
	}

}
