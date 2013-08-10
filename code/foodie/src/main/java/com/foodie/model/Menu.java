package com.foodie.model;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class Menu {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key menuId;
	@Persistent
	private String menuName;
	@Persistent
	private String description;
	@Persistent
	private Key resaurantId;
	
	public Key getMenuId() {
		return menuId;
	}

	public void setMenuId(Key menuId) {
		this.menuId = menuId;
	}
	

	public Menu(String menuName, String description){
		this.menuName  = menuName;
		this.description = description;
	}
	
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
