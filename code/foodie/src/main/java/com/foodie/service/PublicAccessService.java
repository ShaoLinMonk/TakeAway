package com.foodie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodie.config.ApplicationHelper;
import com.foodie.model.Location;
import com.foodie.model.Menu;
import com.foodie.model.MenuItem;
import com.foodie.model.Restaurant;
import com.foodie.repository.MenuDAO;
import com.google.appengine.api.datastore.Key;

@Service
public class PublicAccessService extends AbstractService{

	@Autowired
	private MenuDAO menuDAO;
	public List<Restaurant> getRestaurant(Location location, int bufferSize) 
			throws NullPointerException{
		return null;
	}
	
	public Restaurant getRestaurantById(Key restaurantId)
		throws NullPointerException{
		return null;
	}
	
	public List<Menu> getMenu(Key restaurantId) throws NullPointerException{
		return null;
	}
	
	
	public Menu getMenuById(Key menuId) throws NullPointerException{
		Menu menu = menuDAO.getMenuById(menuId);
		if(menu == null){
			this.ThrowException(new NullPointerException(
					ApplicationHelper.NullPointerExceptionMssg));
		}
		return menu;
	}
	
	public List<MenuItem> getMenuItem(Key menuId) throws NullPointerException{
		List<MenuItem> menuItems= menuDAO.getAllMenuItems(menuId);
		if(menuItems.isEmpty()){
			this.ThrowException(new NullPointerException(
					ApplicationHelper.NullPointerExceptionMssg));
		}
		return menuItems;
	}
	
	public MenuItem getMenuItemById(Key menuItemId){
		MenuItem menuItem = menuDAO.getMenuItemById(menuItemId);
		if(menuItem == null){
			this.ThrowException(new NullPointerException(
					ApplicationHelper.NullPointerExceptionMssg));
		}
		
		return null;
	}
}
