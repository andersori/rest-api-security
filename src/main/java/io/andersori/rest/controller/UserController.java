package io.andersori.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.andersori.rest.entity.User;
import io.andersori.rest.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder crypt;
	
	@PostMapping("/sign-up")
	public void signUp(@RequestBody User user) {
		user.setPassword(crypt.encode(user.getPassword()));
		userRepository.save(user);
	}
}
