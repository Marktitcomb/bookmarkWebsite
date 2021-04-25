package com.website.bookMarkingApp.dao;

import com.website.bookMarkingApp.DataStore;
import com.website.bookMarkingApp.entities.Bookmark;
import com.website.bookMarkingApp.entities.UserBookmark;

public class BookmarkDao {

	public Bookmark [][] getBookmarks(){
		
		return DataStore.getBookmarks();
		
	}

	public void saveUserBookmark(UserBookmark userBookmark) {
		DataStore.add(userBookmark);
		
	}
	
	
}
