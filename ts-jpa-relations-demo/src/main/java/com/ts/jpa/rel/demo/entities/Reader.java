/**
 * 
 */
package com.ts.jpa.rel.demo.entities;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author USER
 *
 */

@Entity
@Table(name = "readers")
public class Reader {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "reader_id")
	private Long readerId;
	
	@Column(name = "reader_name")
	private String username;

	private String password;
	
	private Boolean active;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "sub_id", referencedColumnName = "id")
	private Subscription subscription;
	
	@OneToMany
	@JoinColumn(name = "reader_id", referencedColumnName = "reader_id")
	private List<Book> books;

	public Long getReaderId() {
		return readerId;
	}

	public void setReaderId(Long readerId) {
		this.readerId = readerId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * @return the subscription
	 */
	public Subscription getSubscription() {
		return subscription;
	}

	/**
	 * @param subscription the subscription to set
	 */
	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}

	/**
	 * @return the books
	 */
	
	  public List<Book> getBooks() { return books; }
	 

	/**
	 * @param books the books to set
	 */
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
}
