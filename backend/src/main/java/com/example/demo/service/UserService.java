package com.example.demo.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.TokenUtils;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserService implements UserDetailsService {

	private final UserRepository repo;
	private final RoleRepository roleRepo;
	private final AuthenticationManager authManager;
	private final TokenUtils tokenUtils;
	private final PasswordEncoder passEncoder;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		return repo.findByEmail(email);
	}

	public String login(String email, String password) {
		authManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
		return tokenUtils.generateToken(email);
	}

	public User register(String email, String password) {
		Role role = roleRepo.findByName("kandidat");
		User user = new User(email, passEncoder.encode(password), role);
		return repo.save(user);
	}

}
