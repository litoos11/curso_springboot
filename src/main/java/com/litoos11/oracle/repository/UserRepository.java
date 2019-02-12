package com.litoos11.oracle.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.litoos11.oracle.entity.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Serializable>{
	
	public abstract User findByUsername(String username);
	
}
