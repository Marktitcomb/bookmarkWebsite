package com.website.bookMarkingApp;

import com.website.bookMarkingApp.entities.Bookmark;
import com.website.bookMarkingApp.entities.User;
import com.website.bookMarkingApp.managers.UserManager;
import com.website.bookMarkingApp.managers.BookmarkManager;

public class Launch {
	
	private static User[] users;
	private static Bookmark [][] bookmarks;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		loadData();
		
		
		users = UserManager.getDao().getUsers();
		bookmarks = BookmarkManager.getDao().getBookmarks();
		
		startBookmarking();
		
		System.out.println("Printing all Data...");
		printUserData();
		System.out.println("Printing all bookmarks...");
		printBookmarks();

	}
	
	private static void startBookmarking() {
		for(User user: users) {
			View.bookmark(user, bookmarks);
		}
	}

	public static void loadData() {
		DataStore.loadData();
	}
	
	public static void printBookmarks() {
		for(Bookmark [] bookMarkType: bookmarks) {
			for(Bookmark bookmark: bookMarkType) {
				
				System.out.println(bookmark.toString());
			}
		}
		
	}
	
	public static void printUserData() {
		for(User user: users) {
			System.out.println(user.toString());
		}
		
	}

}
