package com.ctin.classes;

import java.util.ArrayList;

public class Proposition {
	private int id;
	private int votes;
	private String title;
	private String cause;
	private String initiative;
	private String benefits;
	private String direction;
	private float latitude;
	private float longitude;
	private ArrayList<ItemChecklist> goals;
	private ArrayList<ItemChecklist> requirements;
	private ArrayList<Category> categories;
	private ArrayList<String> images;
	private User user;
	private ArrayList<User> helpers;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getVotes() {
		return votes;
	}
	public void setVotes(int votes) {
		this.votes = votes;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCause() {
		return cause;
	}
	public void setCause(String cause) {
		this.cause = cause;
	}
	public String getInitiative() {
		return initiative;
	}
	public void setInitiative(String initiative) {
		this.initiative = initiative;
	}
	public String getBenefits() {
		return benefits;
	}
	public void setBenefits(String benefits) {
		this.benefits = benefits;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	public ArrayList<ItemChecklist> getGoals() {
		return goals;
	}
	public void setGoals(ArrayList<ItemChecklist> goals) {
		this.goals = goals;
	}
	public ArrayList<ItemChecklist> getRequirements() {
		return requirements;
	}
	public void setRequirements(ArrayList<ItemChecklist> requirements) {
		this.requirements = requirements;
	}
	public ArrayList<Category> getCategories() {
		return categories;
	}
	public void setCategories(ArrayList<Category> categories) {
		this.categories = categories;
	}
	public ArrayList<String> getImages() {
		return images;
	}
	public void setImages(ArrayList<String> images) {
		this.images = images;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public ArrayList<User> getHelpers() {
		return helpers;
	}
	public void setHelpers(ArrayList<User> helpers) {
		this.helpers = helpers;
	}
	
	public Proposition(){
		goals = new ArrayList<ItemChecklist>();
		requirements = new ArrayList<ItemChecklist>();
		categories = new ArrayList<Category>();
		images = new ArrayList<String>();
		helpers = new ArrayList<User>();
	}
	
	public Proposition(int id, String title, String cause, String initiative,
			String benefits, String direction, float latitude, float longitude,
			ArrayList<ItemChecklist> goals,
			ArrayList<ItemChecklist> requirements,
			ArrayList<Category> categories, ArrayList<String> images,
			User user, ArrayList<User> helpers) {
		super();
		this.id = id;
		this.title = title;
		this.cause = cause;
		this.initiative = initiative;
		this.benefits = benefits;
		this.direction = direction;
		this.latitude = latitude;
		this.longitude = longitude;
		this.goals = goals;
		this.requirements = requirements;
		this.categories = categories;
		this.images = images;
		this.user = user;
		this.helpers = helpers;
	}
	
}
