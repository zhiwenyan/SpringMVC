package com.storm.steven.entities;

public class User {
	private String Id;
	private String username;
	private String password;
	private Address address;

	public User(String id, String username, String password) {
		super();
		this.Id = id;
		this.username = username;
		this.password = password;
	}
	public User() {		
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		this.Id = id;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Address getAddress() {
		return address;
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

	@Override
	public String toString() {
		return "User [Id=" + Id + ", username=" + username + ", password=" + password + ", address=" + address + "]";
	}
}
