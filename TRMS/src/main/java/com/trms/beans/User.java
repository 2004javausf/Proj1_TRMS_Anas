package com.trms.beans;

public class User {

	String username;
	String password;
	String firstName;
	String lastName;
	String position;
	double accBalance;
	
	
	// Constructors
	public User() {
		super();
		username = "";
		// TODO Auto-generated constructor stub
	}

	public User(String username, String password, String firstName, String lastName, String position,
			double accBalance) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.position = position;
		this.accBalance = accBalance;
	}


	// Setter & Getter Methods
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


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getPosition() {
		return position;
	}


	public void setPosition(String position) {
		this.position = position;
	}


	public double getAccBalance() {
		return accBalance;
	}


	public void setAccBalance(double accBalance) {
		this.accBalance = accBalance;
	}


	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", position=" + position + ", accBalance=" + accBalance + "]";
	}
	
}
