package io.andersori.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.andersori.rest.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByUsername(String username);
}
