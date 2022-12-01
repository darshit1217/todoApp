package com.springboot.springbootproject.todo;

import java.time.LocalDate;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;
//import jakarta.validation.constraints.Size;
//Static List of Todos=> Database (H2,MySQL, Oracle)

//JPA
//Bean -> Database

//@Entity(name="TodoABC")
@Entity
public class Todo {
	public Todo() {

	}
	
	public Todo(int id, String username, String description, LocalDate targetDate, boolean done) {
		super();
		this.id = id;
		this.username = username;
		this.description = description;
		this.targetDate = targetDate;
		this.done = done;
	}
	
	@Id
	@GeneratedValue
	private int id;
	
	// @Column(name="name")
	private String username;
	@Size(min=10, message="Enter atleast 10 characters")
	private String description;
	private LocalDate targetDate;
	private boolean done;

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getTargetDate() {
		return targetDate;
	}

	public void setTargetdate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", username=" + username + ", description=" + description + ", targetDate="
				+ targetDate + ", done=" + done + "]";
	}

}
