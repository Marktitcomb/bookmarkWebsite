package com.website.bookMarkingApp.managers;

import com.website.bookMarkingApp.constants.UserType;
import com.website.bookMarkingApp.dao.UserDao;
import com.website.bookMarkingApp.entities.User;

public class UserManager {

	// creating instance of userMnager class
	public static UserManager instance = new UserManager();
	private static UserDao dao = new UserDao();

	// so you cant instantiate a class
	private UserManager() {}

	public static UserManager getInstance() {
		return instance;
	}

	public User createUser(long id, String email, String firstName, String lastName, int gender, UserType userType) {

		User user = new User();
		user.setId(id);
		user.setEmail(email);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setGender(gender);
		user.setUserType(userType);
		
		return user;

	}
	
	public User[] getUsers() {
		return dao.getUsers();
	}
	
	public static UserDao getDao() {
		return dao;
	}

}
