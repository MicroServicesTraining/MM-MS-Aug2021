/**
 * 
 */
package com.ts.jpa.rel.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ts.jpa.rel.demo.entities.Book;
import com.ts.jpa.rel.demo.repositories.BookRepository;

/**
 * @author USER
 *
 */

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookRepository bookRepository;

	@Override
	public Book addNewBook(Book book) {
		return bookRepository.save(book);
	}
	
	@Override
	public List<Book> fetchAllBooks(){
		return bookRepository.findAll();
	}

}
