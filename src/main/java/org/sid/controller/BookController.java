package org.sid.controller;

import java.util.List;

import org.sid.entities.Book;
import org.sid.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@CrossOrigin("*")
@RequestMapping("/book" ) 
public class BookController {
	private final BookService bookService;
	
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	@GetMapping("/all")
	public ResponseEntity<List<Book>> getAllBooks(){
		List<Book> books = bookService.findAllBooks();
		return new ResponseEntity(books, HttpStatus.OK); 
	}
	
	@GetMapping(value="/book/{id}")
	public ResponseEntity<Book> getBookByIdBook(@PathVariable(name="id") Long id){
		Book book = bookService.findBookByIdBook(id);
		return new ResponseEntity(book, HttpStatus.OK); 
	}
	
	@PostMapping("/add")
	public ResponseEntity<Book> addBook(@RequestBody Book book){
		Book newBook = bookService.createBook(book);
		return new ResponseEntity(newBook, HttpStatus.CREATED); 
	}
	@PutMapping("/update")
	public ResponseEntity<Book> updateBook(@RequestBody Book book){
		Book updateBook = bookService.updateBook(book);
		return new ResponseEntity(updateBook, HttpStatus.OK); 
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteBook(@PathVariable("id") Long id){
		bookService.deleteBook(id);
		return new ResponseEntity(HttpStatus.OK); 
	}

}
