package com.website.bookMarkingApp;

import com.website.bookMarkingApp.controllers.BookmarkController;
import com.website.bookMarkingApp.entities.Bookmark;
import com.website.bookMarkingApp.entities.User;

public class View {
	public static void bookmark(User user, Bookmark[][] bookmarks) {
		
		System.out.println("\n" + user.getEmail() + " is bookmarking");
		//this just represents a user clicking on the screen
		for(int i = 0; i < DataStore.getUserBookmarkLimit(); i++) {
			int typeChoice = (int) Math.random() * DataStore.BOOKMARK_TYPES_COUNT;
			int numberCoice = (int) Math.random() * DataStore.BOOKMARK_COUNT_PER_TYPE;
			
			//just representing a user input 
			Bookmark bookmark = bookmarks[typeChoice][numberCoice];
			
			//so someones just clicked and whats to save a bookmark 
			BookmarkController.getInstance().saveUserBookmark(user, bookmark);
			
			System.out.print("User has created a new bookmark");
			System.out.print(bookmark);
			
		}
	}
}
