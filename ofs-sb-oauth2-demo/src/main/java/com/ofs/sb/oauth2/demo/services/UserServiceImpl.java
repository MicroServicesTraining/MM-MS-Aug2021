package com.ofs.sb.oauth2.demo.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ofs.sb.oauth2.demo.dao.UserDAO;
import com.ofs.sb.oauth2.demo.model.User;

/**
 * 
 */

/**
 * @author dorak
 *
 */
@Service(value = "userServiceImpl")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDao;

	@Override
	public List<User> findAll() {
		List<User> list = new ArrayList<>();
		userDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public void delete(Long id) {
		userDao.deleteById(id);		
	}

	@Override
	public User save(User user) {
		return userDao.save(user);
	}

	@Override
	public User findUserById(Long id) {
		return userDao.findById(id).get();
	}

}