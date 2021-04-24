package com.website.bookMarkingApp;

import com.website.bookMarkingApp.entities.*;
import com.website.bookMarkingApp.constants.*;
import com.website.bookMarkingApp.managers.*;

public class DataStore {
	
	private static final int USER_BOOKMARK_LIMIT = 5;
	private static final int BOOKMARK_COUNT_PER_TYPE = 5;
	private static final int BOOKMARK_TYPES_COUNT = 3;
	private static final int TOTAL_USER_COUNT = 5;
	//three data structures 
	private static User[] users = new User[TOTAL_USER_COUNT];
	//three types of bookmarks 5 of each 
	private static Bookmark [][] bookmarks = new Bookmark [BOOKMARK_TYPES_COUNT][BOOKMARK_COUNT_PER_TYPE];
	//5 users each can have 5 bookmarks 
	private static  UserBookmark[] userBookmarks = new UserBookmark[TOTAL_USER_COUNT*USER_BOOKMARK_LIMIT];
	
	
	
	public static void loadData() {
		loadUsers();
	}
	
	private static void loadUsers() {
		users[0] = UserManager.getInstance().createUser(1000,	"user0@semanticsquare.com",	"John",	"M", Gender.MALE,	UserType.USER);
		
		
	}
	
	private static void loadWeblinks() {
		bookmarks[0][1] = 
	}
}
