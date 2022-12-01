package com.springboot.springbootproject.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
@Service
public class TodoService {
	private static List<Todo> todos=new ArrayList<>();
	private static int todosCount=0;
//	If you want to insulate the static variable, you need to create a static block.
	
	static {
		todos.add(new Todo(++todosCount,"darshit","Learn AWS Tech 1",LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todosCount,"darshit","Learn DevOps 1",LocalDate.now().plusYears(2), false));
		todos.add(new Todo(++todosCount,"darshit","Learn Full Stack Development 1",LocalDate.now().plusYears(3), false));
	}
	public List<Todo> findByUsername(String username){
		Predicate<? super Todo> predicate= todo->todo.getUsername().equalsIgnoreCase(username);
		return todos.stream().filter(predicate).toList();
	}
	public void addTodo(String username,String description,LocalDate targetDate,boolean done) {
		Todo todo=new Todo(++todosCount,username,description,targetDate,done);
		todos.add(todo);
	}
	public void deleteById(int id) {
		Predicate<? super Todo> predicate= todo->todo.getId()==id;
		todos.removeIf(predicate);
	}
	public Todo findById(int id) {
		// TODO Auto-generated method stub
		Predicate<? super Todo> predicate= todo->todo.getId()==id;
		Todo todo=todos.stream().filter(predicate).findFirst().get();
		// for loop can also be used lecture 51- Spring boot in 100 steps
		return todo;
	}
	public void updateTodo(@Valid Todo todo) {
		deleteById(todo.getId());
		todos.add(todo);
	}
}
