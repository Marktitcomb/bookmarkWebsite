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


	public void saveUserBookmark(User user, Bookmark bookmark) {
		BookmarkManager.getInstance().saveUserBookmark(user, bookmark);
		
	}
}
