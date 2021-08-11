/**
 * 
 */
package com.ts.jpa.rel.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ts.jpa.rel.demo.entities.Reader;
import com.ts.jpa.rel.demo.repositories.ReaderRepository;

/**
 * @author USER
 *
 */
@Service
@Transactional(rollbackOn = {Exception.class})
public class ReaderServiceImpl implements ReaderService{

	@Autowired
	private ReaderRepository readerRepository;

	@Override
	public Reader addNewReader(Reader reader) {
		return readerRepository.save(reader);
	}

	@Override
	public List<Reader> fetchAllReaders() {
		return readerRepository.findAll();
	}

}
