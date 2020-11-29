package com.uebp.apialunos.service;

import java.util.ArrayList;

import com.uebp.apialunos.models.UserAluno;
import com.uebp.apialunos.repository.UserAlunoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
    private UserAlunoRepository userAlunoRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserAluno user = userAlunoRepository.findByUsername(username);
		
		if (user.getUsername().equals(username)) {
			return new User(username, user.getPassword(), new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
}