package com.ctin.classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;


public final class CityChanges {
	
	public static String CityChangesUrl = "http://mysterious-bayou-7847.herokuapp.com/";
	
	private static Map<Integer, Proposition> propositions = new HashMap<Integer, Proposition>();
	private static Map<Integer, User> users = new HashMap<Integer, User>();
	private static Map<Integer, Category> categories = new HashMap<Integer, Category>();
	
	public static Map<Integer, Proposition> getPropositions() {
		return propositions;
	}

	public static void setPropositions(Map<Integer, Proposition> propositions) {
		CityChanges.propositions = propositions;
	}

	public static Map<Integer, User> getUsers() {
		return users;
	}

	public static void setUsers(Map<Integer, User> users) {
		CityChanges.users = users;
	}
	
	public static Map<Integer, Category> getCategories() {
		return categories;
	}

	public static void setCategories(Map<Integer, Category> categories) {
		CityChanges.categories = categories;
	}

	public static void loadUrl(){
		try{
			loadCategories(CityChangesUrl+"categories.json");
			loadPropositions(CityChangesUrl+"propositions.json");
		}catch(Exception ex){
			Log.i("loadUrl", ex.getLocalizedMessage());
		}
	}
	
	public static void loadCategories(String path) throws Exception{
		String jsonStringCategories = getSourceCode(path);
		parseJsonCategories(jsonStringCategories);
	}
	private static void parseJsonCategories(String jsonStringCategories) throws Exception{
		JSONArray jsonArray = new JSONArray(jsonStringCategories);
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			JSONObject jsonCategory = jsonObject.getJSONObject("category");
			Category c = new Category();
			c.setId(jsonCategory.getInt("id"));
			c.setName(jsonCategory.getString("name"));
			c.setDescription(jsonCategory.getString("description"));
			categories.put(new Integer(c.getId()), c);
		}
	}
	
	public static void loadUser(int id) throws Exception{
		String jsonStringUser = getSourceCode(CityChangesUrl+"users/"+id+".json");
		parseJsonUser(jsonStringUser);
	}
	public static void parseJsonUser(String jsonStringUser) throws Exception{
		JSONObject jsonObject = new JSONObject(jsonStringUser);
		JSONObject jsonUser = jsonObject.getJSONObject("user");
		User u = new User();
		u.setId(jsonUser.getInt("id"));
		u.setFirstname(jsonUser.getString("firstname"));
		u.setLastname(jsonUser.getString("lastname"));
		u.setPicture(jsonUser.getString("picture"));
		u.setEmail(jsonUser.getString("email"));
		u.setUid(jsonUser.getString("uid"));
		users.put(new Integer(u.getId()), u);
	}
	
	
	public static void loadPropositions(String path) throws Exception{
		String jsonStringPropositions = getSourceCode(path);
		parseJsonPropositions(jsonStringPropositions);
	}
	private static void parseJsonPropositions(String jsonStringPropositions) throws JSONException, Exception{
		JSONArray jsonArray = new JSONArray(jsonStringPropositions);
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			JSONObject jsonProposition = jsonObject.getJSONObject("proposition");
			JSONObject jsonUser = jsonProposition.getJSONObject("user");
			int id_user = jsonUser.getInt("id");
			if(!users.containsKey(id_user)){
				User u = new User();
				u.setId(id_user);
				users.put(new Integer(u.getId()), u);
			}
			Proposition p = new Proposition();
			p.setId(jsonProposition.getInt("id"));
			p.setTitle(jsonProposition.getString("title"));
			p.setCause(jsonProposition.getString("cause"));
			p.setInitiative(jsonProposition.getString("initiative"));
			p.setBenefits(jsonProposition.getString("benefits"));
			p.setDirection(jsonProposition.getString("direction"));
			p.setLatitude(jsonProposition.getDouble("latitude"));
			p.setLongitude(jsonProposition.getDouble("longitude"));
			p.setVotes(jsonProposition.getInt("up_votes"));
			p.setUser(users.get(id_user));
			
			users.get(id_user).getMyPropositions().add(p);
			propositions.put(new Integer(p.getId()), p);
			
			ArrayList<ItemChecklist> goals = new ArrayList<ItemChecklist>();
			p.setGoals(goals);
			ArrayList<ItemChecklist> requirements = new ArrayList<ItemChecklist>();
			p.setRequirements(requirements);
			ArrayList<Category> categories = new ArrayList<Category>();
			p.setCategories(categories);
			ArrayList<String> images = new ArrayList<String>();
			p.setImages(images);
			
			JSONArray jsonGoals = jsonProposition.getJSONArray("goals");
			JSONArray jsonRequirements = jsonProposition.getJSONArray("requirements");
			JSONArray jsonCategories = jsonProposition.getJSONArray("categories");
			JSONArray jsonImages = jsonProposition.getJSONArray("images");
			JSONArray jsonContributors = jsonProposition.getJSONArray("contributors");
			
			for(int ig = 0; ig < jsonGoals.length(); ig++) {
				JSONObject jsonGoal = jsonGoals.getJSONObject(ig);
				ItemChecklist ic = new ItemChecklist();
				ic.setTitle(jsonGoal.getString("title"));
				ic.setDone(jsonGoal.getBoolean("done"));
				goals.add(ic);
			}
			
			for(int ir = 0; ir < jsonRequirements.length(); ir++) {
				JSONObject jsonRequirement = jsonRequirements.getJSONObject(ir);
				ItemChecklist ic = new ItemChecklist();
				ic.setTitle(jsonRequirement.getString("title"));
				ic.setDone(jsonRequirement.getBoolean("done"));
				requirements.add(ic);
			}
			
			for (int ic = 0; ic < jsonCategories.length(); ic++) {
				JSONObject jsonCategory = jsonCategories.getJSONObject(ic);
				p.getCategories().add(CityChanges.categories.get(jsonCategory.getInt("id")));
			}
			
			for (int ii = 0; ii < jsonImages.length(); ii++) {
				JSONObject jsonImage = jsonImages.getJSONObject(ii);
				images.add(jsonImage.getString("url"));
			}
			
			for (int ic = 0; ic < jsonContributors.length(); ic++) {
				JSONObject jsonContributor = jsonContributors.getJSONObject(ic);
				int contributor_id = jsonContributor.getInt("id");
				if(!CityChanges.users.containsKey(contributor_id))
					loadUser(contributor_id);
				p.getHelpers().add(CityChanges.users.get(contributor_id));
				CityChanges.users.get(contributor_id).getMorePropositions().add(p);
			}
		}
	}
	
	
	private static String getSourceCode(String url) throws Exception {
		URL webpage = new URL(url);
		URLConnection connection = webpage.openConnection();
		BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String line = "";
		StringBuilder sb = new  StringBuilder();
		while((line = br.readLine()) != null){
			sb.append(line);
		}
		br.close();
		return sb.toString();
	}
	
}
