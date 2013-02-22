package com.ctin.classes;

import java.util.ArrayList;

public class User {
	
	private int id;
	private String uid;
	private String firstname;
	private String lastname;
	private String picture;
	private String email;
	private ArrayList<Proposition> myPropositions;
	private ArrayList<Proposition> morePropositions;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
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
	public ArrayList<Proposition> getMyPropositions() {
		return myPropositions;
	}
	public void setMyPropositions(ArrayList<Proposition> myPropositions) {
		this.myPropositions = myPropositions;
	}
	public ArrayList<Proposition> getMorePropositions() {
		return morePropositions;
	}
	public void setMorePropositions(ArrayList<Proposition> morePropositions) {
		this.morePropositions = morePropositions;
	}
	
	public User(){
		setMyPropositions(new ArrayList<Proposition>());
		setMorePropositions(new ArrayList<Proposition>());
	}
	
	public User(int id, String firstname, String lastname, String picture,
			String email, ArrayList<Proposition> myPropositions, ArrayList<Proposition> morePropositions) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.picture = picture;
		this.email = email;
		this.myPropositions = myPropositions;
		this.morePropositions = morePropositions;
	}
	
	
}
