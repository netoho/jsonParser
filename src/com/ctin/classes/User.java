package com.ctin.classes;

import java.util.ArrayList;

public class User {
	
	private int id;
	private String firstname;
	private String lastname;
	private String picture;
	private String email;
	private ArrayList<Proposition> propositions;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public ArrayList<Proposition> getPropositions() {
		return propositions;
	}
	public void setPropositions(ArrayList<Proposition> propositions) {
		this.propositions = propositions;
	}
	
	public User(){
		setPropositions(new ArrayList<Proposition>());
	}
	
	public User(int id, String firstname, String lastname, String picture,
			String email, ArrayList<Proposition> propositions) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.picture = picture;
		this.email = email;
		this.propositions = propositions;
	}
	
	
}
