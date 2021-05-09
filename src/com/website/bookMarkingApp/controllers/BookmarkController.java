package com.website.bookMarkingApp.controllers;

import com.website.bookMarkingApp.entities.Bookmark;
import com.website.bookMarkingApp.entities.User;
import com.website.bookMarkingApp.managers.BookmarkManager;

public class BookmarkController {
	
	private static BookmarkController instance = new BookmarkController();
	
	private BookmarkController() {}

	
	public static BookmarkController getInstance() {
		
		return instance;
	}


	//this is the controller connecting to the model 
	//the controller only performs this one task at present 
	public void saveUserBookmark(User user, Bookmark bookmark) {
		BookmarkManager.getInstance().saveUserBookmark(user, bookmark);
		
	}


	public void setIsKidFriendlyEligible(User user, String childFriendlyStatus, Bookmark bookmark) {
		// dont want business logic in controller 
		BookmarkManager.getInstance().setIsKidFriendlyEligible(user, childFriendlyStatus, bookmark);
		
	}


	public void shareBookmark(User user, Bookmark bookmark) {
		BookmarkManager.shareBookmark(user, bookmark); 
		
	}
}
