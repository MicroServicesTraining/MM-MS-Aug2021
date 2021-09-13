/**
 * 
 */
package com.ofs.sb.oauth2.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ofs.sb.oauth2.demo.model.User;

/**
 * @author dorak
 *
 */
@Repository
public interface UserDAO extends JpaRepository<User, Long>{

	public User findByUsername(String useName);

}
