package com.website.bookMarkingApp.controllers;

import java.sql.SQLException;

import com.website.bookMarkingApp.constants.ChildFriendlyEligible;
import com.website.bookMarkingApp.entities.Bookmark;
import com.website.bookMarkingApp.entities.User;
import com.website.bookMarkingApp.managers.BookmarkManager;

public class BookmarkController {
	
	
	
	//********************FAKE CLASS***********************************//
	
		// This class would be a servlet controller in the web enabled
		// project 
		
		
		//******************************************************************
		
	
	
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


	public void setIsKidFriendlyEligible(User user, ChildFriendlyEligible childFriendlyStatus, Bookmark bookmark) throws SQLException {
		// dont want business logic in controller 
		BookmarkManager.getInstance().setIsKidFriendlyEligible(user, childFriendlyStatus, bookmark);
		
	}


	public void shareBookmark(User user, Bookmark bookmark) {
		BookmarkManager.shareBookmark(user, bookmark); 
		
	}
}
