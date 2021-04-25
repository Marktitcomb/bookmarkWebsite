package com.website.bookMarkingApp;

import com.website.bookMarkingApp.entities.*;
import com.website.bookMarkingApp.constants.*;
import com.website.bookMarkingApp.managers.*;

public class DataStore {

	private static final int USER_BOOKMARK_LIMIT = 5;
	public static final int BOOKMARK_COUNT_PER_TYPE = 5;
	public static final int BOOKMARK_TYPES_COUNT = 3;
	private static final int TOTAL_USER_COUNT = 5;
	// three data structures
	private static User[] users = new User[TOTAL_USER_COUNT];
	
	
	public static User[] getUsers() {
		return users;
	}

	public static UserBookmark[] getUserBookmarks() {
		return userBookmarks;
	}
	public static Bookmark[][] getBookmarks() {
		return bookmarks;
	}
	
	public static int getUserBookmarkLimit() {
		return USER_BOOKMARK_LIMIT;
	}




	// three types of bookmarks 5 of each
	private static Bookmark[][] bookmarks = new Bookmark[BOOKMARK_TYPES_COUNT][BOOKMARK_COUNT_PER_TYPE];
	// 5 users each can have 5 bookmarks
	private static UserBookmark[] userBookmarks = new UserBookmark[TOTAL_USER_COUNT * USER_BOOKMARK_LIMIT];
	private static int bookmarkIndex;

	public static void loadData() {
		loadUsers();
		loadWeblinks();
		loadBooks();
		loadMovies();
	}

	private static void loadUsers() {
		users[0] = UserManager.getInstance().createUser(1000, "user0@semanticsquare.com", "John", "M", Gender.MALE,
				UserType.USER);
		users[1] = UserManager.getInstance().createUser(1001, "user1@semanticsquare.com", "Sam M", "M", Gender.MALE,
				UserType.USER);
		users[2] = UserManager.getInstance().createUser(1002, "user2@semanticsquare.com", "Anita", "M", Gender.MALE,
				UserType.EDITOR);
		users[3] = UserManager.getInstance().createUser(1003, "user3@semanticsquare.com", "Sara", "M", Gender.FEMALE,
				UserType.EDITOR);
		users[4] = UserManager.getInstance().createUser(1004, "user4@semanticsquare.com", "Dheeru", "M", Gender.MALE,
				UserType.CHIEF_EDITOR);
	}

	private static void loadWeblinks() {
		bookmarks[0][0] = BookmarkManager.getInstance().createWeblink(2000, "Taming Tiger",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html", "unknown");
		bookmarks[0][1] = BookmarkManager.getInstance().createWeblink(2001, "Taming Tiger 1",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html", "unknown");
		bookmarks[0][2] = BookmarkManager.getInstance().createWeblink(2002, "Taming Tiger 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html", "unknown");
		bookmarks[0][3] = BookmarkManager.getInstance().createWeblink(2003, "Taming Tiger 3",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html", "unknown");
		bookmarks[0][4] = BookmarkManager.getInstance().createWeblink(2004, "Taming Tiger 4",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html", "unknown");
	}

	private static void loadBooks() {
		bookmarks[1][0] = BookmarkManager.getInstance().createBook(4000, "Walden", 1854, "Wilder Publications", 4.3);
		bookmarks[1][1] = BookmarkManager.getInstance().createBook(4001, "Walden2", 1854, "Wilder Publications", 4.3);
		bookmarks[1][2] = BookmarkManager.getInstance().createBook(4002, "Walden3", 1854, "Wilder Publications", 4.3);
		bookmarks[1][3] = BookmarkManager.getInstance().createBook(4003, "Walden4", 1854, "Wilder Publications", 4.3);
		bookmarks[1][4] = BookmarkManager.getInstance().createBook(4004, "Walden5", 1854, "Wilder Publications", 4.3);
	}

	private static void loadMovies() {
		bookmarks[2][0] = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", "url", 1941,
				new String[] { "Orson Welles", "Joseph Cotten" }, new String[] { "Orson Welles", "Joseph Cotten" },
				MovieGenre.CLASSICS, 84);
		bookmarks[2][1] = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", "url", 1941,
				new String[] { "Orson Welles", "Joseph Cotten" }, new String[] { "Orson Welles", "Joseph Cotten" },
				MovieGenre.CLASSICS, 84);
		bookmarks[2][2] = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", "url", 1941,
				new String[] { "Orson Welles", "Joseph Cotten" }, new String[] { "Orson Welles", "Joseph Cotten" },
				MovieGenre.CLASSICS, 84);
		bookmarks[2][3] = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", "url", 1941,
				new String[] { "Orson Welles", "Joseph Cotten" }, new String[] { "Orson Welles", "Joseph Cotten" },
				MovieGenre.CLASSICS, 84);
		bookmarks[2][4] = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", "url", 1941,
				new String[] { "Orson Welles", "Joseph Cotten" }, new String[] { "Orson Welles", "Joseph Cotten" },
				MovieGenre.CLASSICS, 84);
	}

	public static void add(UserBookmark userBookmark) {
		userBookmarks[bookmarkIndex] = userBookmark;
		bookmarkIndex ++;
		
	}

}
