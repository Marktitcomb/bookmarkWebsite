package com.website.bookMarkingApp.managers;

import com.website.bookMarkingApp.dao.BookmarkDao;
import com.website.bookMarkingApp.entities.*;

public class BookmarkManager {

	private static BookmarkManager instance = new BookmarkManager();
	private static BookmarkDao dao = new BookmarkDao();

	private BookmarkManager() {
	}

	// this is the only public function here
	// singleton doesnt want to instantiate the class more than once so you have a
	// private constructor
	// developers using this class will not be able to create multiple instances
	public static BookmarkManager getInstance() {

		return instance;
	}

	// rather than constructing a movie object in it's class, the manager does this
	// for you
	public Movie createMovie(long id, String title, String profileUrl, int releaseYear, String[] cast,
			String[] directors, int genre, int imdbRating) {

		Movie movie = new Movie();
		movie.setId(id);
		movie.setTitle(title);
		movie.setProfileUrl(profileUrl);
		movie.setReleaseYear(releaseYear);
		movie.setCast(cast);
		movie.setDirectors(directors);
		movie.setGenre(genre);
		movie.setImdbRating(imdbRating);

		return movie;

	}

	public Book createBook(long id, String title, int publicationYear, String publisher, double amazonRating) {

		Book book = new Book();
		book.setId(id);
		book.setTitle(title);
		book.setPublishYear(publicationYear);
		book.setPublisher(publisher);
		book.setAmazonRating(amazonRating);

		return book;

	}

	public Weblink createWeblink(long id, String title, String url, String host) {

		Weblink weblink = new Weblink();
		weblink.setHost(host);
		weblink.setId(id);
		weblink.setProfileUrl(url);
		weblink.setTitle(title);

		return weblink;

	}

	public Bookmark[][] getBookmarks() {
		return dao.getBookmarks();
	}

	public static BookmarkDao getDao() {
		return dao;
	}

	public void saveUserBookmark(User user, Bookmark bookmark) {
		UserBookmark userBookmark = new UserBookmark();
		userBookmark.setUser(user);
		userBookmark.setBookmark(bookmark);

		dao.saveUserBookmark(userBookmark);

	}

	public void setIsKidFriendlyEligible(User user, String childFriendlyStatus, Bookmark bookmark) {
		bookmark.setIsKidFriendlyEligible(childFriendlyStatus);
		bookmark.setChildFriendlyMarkedBY(user);
		System.out.println("Child Friendly status " + childFriendlyStatus + "," + bookmark);
		System.out.println("Child Friendly status marked by" + user.getEmail());

	}

	public static void shareBookmark(User user, Bookmark bookmark) {
		bookmark.setSharedBy(user);
		System.out.println("Data being shared by: " + user);
		if(bookmark instanceof Book) {
			System.out.println("Data to be shared: " + ((Book) bookmark).getItemData()); 
		}else if(bookmark instanceof Weblink) {
			System.out.println("Data to be shared: " + ((Weblink) bookmark).getItemData()); 
		}
	}

}
