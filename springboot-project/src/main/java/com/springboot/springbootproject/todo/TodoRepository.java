package com.springboot.springbootproject.todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

//In JPA Repository
//T-> What is to be managed
//ID-> type of that ID field


//Spring data JPA would automatically provide a method to search by username.
public interface TodoRepository extends JpaRepository<Todo, Integer>{
	public List<Todo> findByUsername(String username);
}
