/**
 * 
 */
package com.ts.jpa.rel.demo.service;

import java.util.List;

import com.ts.jpa.rel.demo.entities.Reader;

/**
 * @author USER
 *
 */
public interface ReaderService {
	public Reader addNewReader(Reader reader);

	public List<Reader> fetchAllReaders();
}
