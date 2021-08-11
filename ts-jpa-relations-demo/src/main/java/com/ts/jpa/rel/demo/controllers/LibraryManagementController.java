/**
 * 
 */
package com.ts.jpa.rel.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ts.jpa.rel.demo.entities.Book;
import com.ts.jpa.rel.demo.entities.Reader;
import com.ts.jpa.rel.demo.entities.Subscription;
import com.ts.jpa.rel.demo.service.BookService;
import com.ts.jpa.rel.demo.service.ReaderService;
import com.ts.jpa.rel.demo.service.SubscriptionService;

/**
 * @author USER
 *
 */
@RestController
public class LibraryManagementController {
	
	@Value("${app.title}")
	private String appTitle;

	@Autowired
	private ReaderService readerService;
	
	@Autowired
	private BookService bookService;

	@Autowired
	private SubscriptionService subscriptionService;

	@GetMapping
	public String sayWelcome() {
		return "<h1>Welcome to "+appTitle+"</h1>";
	}
	
	@PostMapping("newreader")
	public Reader addNewReader(@RequestBody Reader reader) {
		return readerService.addNewReader(reader);
	}
	
	@GetMapping("readers")
	public List<Reader> fetchAllReaders(){
		return readerService.fetchAllReaders();
	}
	
	@PostMapping("newbook")
	public Book addBook(@RequestBody Book book) {
		return bookService.addNewBook(book);
	}

	@GetMapping("books")
	public List<Book> fetchAllBooks(){
		return bookService.fetchAllBooks();
	}
	
	@PostMapping("newsubscription")
	public Subscription addNewSubscription(@RequestBody Subscription subscription) {
		return subscriptionService.addNewSubscription(subscription);		
	}

	/**
	 * @return the appTitle
	 */
	public String getAppTitle() {
		return appTitle;
	}

	/**
	 * @param appTitle the appTitle to set
	 */
	public void setAppTitle(String appTitle) {
		this.appTitle = appTitle;
	}
	
}
