package com.ctin.classes;

public class Category {
	private int id;
	private String name;
	private String description;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String title) {
		this.name = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Category(){}
	public Category(int id, String title, String description){
		this.id = id;
		this.name = title;
		this.description = description;
	}
}
