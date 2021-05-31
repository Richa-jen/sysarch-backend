package com.ridersbuddy.finals.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customers")
public class Customer {
	@Id
	private String id;
	private String lastname;
	private String firstname;
	private String username;
	private String password;
	private String email;
	private boolean stats;
	
	public Customer() {
		
	}

	public Customer(String lastname, String firstname, String username, String password, String email,
			boolean stats) {

		this.lastname = lastname;
		this.firstname = firstname;
		this.username = username;
		this.password = password;
		this.email = email;
		this.stats = stats;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isStats() {
		return stats;
	}

	public void setStats(boolean stats) {
		this.stats = stats;
	}
	
	
}
