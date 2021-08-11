/**
 * 
 */
package com.ts.jpa.rel.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author USER
 *
 */
@Entity
@Table(name = "books")
public class Book {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "book_id")
	private Long bookId;
	
	@Column(name = "book_name")
	private String bookName;
	
	@Column(name = "author")
	private String author;

	
	/*
	 * @Column(name = "reader_id") private Long readerId;
	 */
	
	@ManyToOne
	@JoinColumn(name = "reader_id", referencedColumnName = "reader_id")
	private Reader reader;
	
	/**
	 * @return the bookId
	 */
	public Long getBookId() {
		return bookId;
	}

	/**
	 * @param bookId the bookId to set
	 */
	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	/**
	 * @return the bookName
	 */
	public String getBookName() {
		return bookName;
	}

	/**
	 * @param bookName the bookName to set
	 */
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the readerId
	 */
	/*
	 * public Long getReaderId() { return readerId; }
	 */

	/**
	 * @param readerId the readerId to set
	 */
	/*
	 * public void setReaderId(Long readerId) { this.readerId = readerId; }
	 */

	/**
	 * @return the reader
	 */
	/*
	 * public Reader getReader() { return reader; }
	 */

	/**
	 * @param reader the reader to set
	 */
	public void setReader(Reader reader) {
		this.reader = reader;
	}
	
}
