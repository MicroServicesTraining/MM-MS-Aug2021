/**
 * 
 */
package com.ts.jpa.rel.demo.service;

import java.util.List;

import com.ts.jpa.rel.demo.entities.Book;

/**
 * @author USER
 *
 */
public interface BookService {

	Book addNewBook(Book book);

	List<Book> fetchAllBooks();	

}
