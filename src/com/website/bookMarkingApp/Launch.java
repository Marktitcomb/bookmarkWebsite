package com.website.bookMarkingApp;

import com.website.bookMarkingApp.entities.Bookmark;

import java.sql.SQLException;
import java.util.List;
import com.website.bookMarkingApp.entities.User;
import com.website.bookMarkingApp.managers.UserManager;
import com.website.bookMarkingApp.managers.BookmarkManager;

public class Launch{
	
	private static List<User> users;
	private static List<List<Bookmark>> bookmarks;

	public static void main(String[] args) throws SQLException {
		
		loadData();
		
		
		users = DataStore.getUsers();
		bookmarks = DataStore.getBookmarks();
		
		start();
	}
	
	private static void start() throws SQLException{
		// TODO Auto-generated method stub
		//bookmarks are just the list of movies
		//list of weblinks and books
		
		//there are all subclasses of bookmark 
		for(User user: users) {
			View.browse(user, bookmarks);
			
		}
		
	}

	public static void loadData() {
		DataStore.loadData();
		
	
	
	
	}
	
	public static void printUserData() {
		for(User user: users) {
			System.out.println(user.toString());
		}
		
	}

}
