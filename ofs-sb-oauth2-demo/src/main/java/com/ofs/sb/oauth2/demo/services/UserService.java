/**
 * 
 */
package com.ofs.sb.oauth2.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ofs.sb.oauth2.demo.model.User;

/**
 * @author dorak
 *
 */

public interface UserService{

	List<User> findAll();

	void delete(Long id);

	User save(User user);

	User findUserById(Long id);

}
