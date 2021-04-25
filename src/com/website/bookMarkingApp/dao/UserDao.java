package com.website.bookMarkingApp.dao;

import com.website.bookMarkingApp.DataStore;
import com.website.bookMarkingApp.entities.User;

public class UserDao {
	
	public User [] getUsers() {
		
		return DataStore.getUsers();
	}

}
