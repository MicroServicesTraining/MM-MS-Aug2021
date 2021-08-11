/**
 * 
 */
package com.ts.jpa.rel.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ts.jpa.rel.demo.entities.Book;

/**
 * @author USER
 *
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
