package com.example.demo.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Login;

public interface LoginRepository extends JpaRepository<Login,String> {
	@Query
	public Optional<Login> findByUserId(String userId);
}