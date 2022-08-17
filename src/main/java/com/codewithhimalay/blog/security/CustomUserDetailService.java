package com.codewithhimalay.blog.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;

import com.codewithhimalay.blog.entity.User;
import com.codewithhimalay.blog.exception.ResourceNotFoundException;
import com.codewithhimalay.blog.repository.UserRepository;
@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		User user=this.userRepository.findByEmail(username).orElseThrow(()->new ResourceNotFoundException("User ", "Email "+ username,0));
		return user;
	}

}
