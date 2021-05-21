package com.website.bookMarkingApp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.website.bookMarkingApp.constants.*;
import com.website.bookMarkingApp.managers.*;
import com.website.bookMarkingApp.entities.*;


public class DataStore {

	private static List<User> users = new ArrayList<>();
	public static List<User> getUsers() {
		return users;
	}

	private static List<List<Bookmark>> bookmarks = new ArrayList<>();
	public static List<List<Bookmark>> getBookmarks() {
		return bookmarks;
	}

	private static List<UserBookmark> userBookmarks = new ArrayList<>();
	
	public static void loadData() {
//		loadUsers();
//		loadWeblinks();
//		loadBooks();
//		loadMovies();
		
		
		try {
			//loading the jdbc driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = "jdbc:mysql://localhost:3306/bookmarkingAppDB?useSSL=false";
		String user = "root";
		String password = "Guitar0903";
		// Connection string: <protocol>:<sub-protocol>:<data-source details>
		try (
			    Connection conn = DriverManager.getConnection(url, user, password);
				Statement stmt = conn.createStatement();
				) {
			loadUsers(stmt);
			//loadWebLinks(stmt); 
			//loadMovies(stmt);
			loadBooks(stmt);
			
			//System.out.println(bookmarks);
				
		}catch(SQLException e) {
			e.printStackTrace();
		}
			
	}
	
	private static void loadMovies(Statement stmt) throws SQLException {
		String query = "Select m.id, title, release_year, GROUP_CONCAT(DISTINCT a.name SEPARATOR ',') AS cast, GROUP_CONCAT(DISTINCT d.name SEPARATOR ',') AS directors, movie_genre_id, imdb_rating"
				+ " from Movie m, Actor a, Movie_Actor ma, Director d, Movie_Director md "
				+ "where m.id = ma.movie_id and ma.actor_id = a.id and "
				      + "m.id = md.movie_id and md.director_id = d.id group by m.id";
		ResultSet rs = stmt.executeQuery(query);
		
		List<Bookmark> bookmarkList = new ArrayList<>();
		while (rs.next()) {
			long id = rs.getLong("id");
			String title = rs.getString("title");
			int releaseYear = rs.getInt("release_year");
			String[] cast = rs.getString("cast").split(",");
			String[] directors = rs.getString("directors").split(",");			
			int genre_id = rs.getInt("movie_genre_id");
			//MovieGenre genre = MovieGenre.values()[genre_id];
			int imdbRating = (int) rs.getDouble("imdb_rating");
			
	
			
			Bookmark bookmark = BookmarkManager.getInstance().createMovie(id, title, "", releaseYear, cast, directors, genre_id, imdbRating/*, values[7]*/);
    		bookmarkList.add(bookmark); 
		}
		bookmarks.add(bookmarkList);
	}
	
	private static void loadBooks(Statement stmt) throws SQLException {		
		//query the database
		String query = "Select b.id, title, publication_year, p.name, GROUP_CONCAT(a.name SEPARATOR ',') AS authors, book_genre_id, amazon_rating"
				+ " from Book b, Publisher p, Author a, Book_Author ba "//from all the individual tables 
				+ "where b.publisher_id = p.id and b.id = ba.book_id and ba.author_id = a.id group by b.id"; //where i.e the Book-table publisher id
					//is the same as the publisher-table id
		//get your result
    	ResultSet rs = stmt.executeQuery(query);
    	//rs is a long list of results side by side 
		//put the result into your java application until result is empty
    	List<Bookmark> bookmarkList = new ArrayList<>();
    	while (rs.next()) {
    		long id = rs.getLong("id");
    	
			String title = rs.getString("title");
			int publicationYear = rs.getInt("publication_year");
			String publisher = rs.getString("name");
			//System.out.println(publisher);
			String[] authors = rs.getString("authors").split(",");			
			int genre_id = rs.getInt("book_genre_id");
			//BookGenre genre = BookGenre.values()[genre_id];
			double amazonRating = rs.getDouble("amazon_rating");
			
			//Date createdDate = rs.getDate("created_date");
			//System.out.println("createdDate: " + createdDate);
			//Timestamp timeStamp = rs.getTimestamp(8);
			//System.out.println("timeStamp: " + timeStamp);
			//System.out.println("localDateTime: " + timeStamp.toLocalDateTime());
			
			//System.out.println("id: " + id + ", title: " + title + ", publication year: " + publicationYear + ", publisher: " + publisher + ", authors: " + String.join(", ", authors) + ", genre: "  + ", amazonRating: " + amazonRating);
    		
			
    		Bookmark bookmark = BookmarkManager.getInstance().createBook(id, title, publicationYear, publisher,  amazonRating);
    		bookmark.setKidFriendlyEligible(ChildFriendlyEligible.UNKNOWN);
    		
    		//System.out.println(book.getItemData());
    		
    		//System.out.println(bookmark.getId());
    		//System.out.println(bookmark.toString());
    		
    		bookmarkList.add(bookmark); 
    	}
    	bookmarks.add(bookmarkList);
    }	
	
//	private static void loadWeblinks(Statement stmt) throws SQLException {		
//		//query the database
//		String query = "Select b.id, title, publication_year, p.name, GROUP_CONCAT(a.name SEPARATOR ',') AS authors, book_genre_id, amazon_rating"
//				+ " from Book b, Publisher p, Author a, Book_Author ba "//from all the individual tables 
//				+ "where b.publisher_id = p.id and b.id = ba.book_id and ba.author_id = a.id group by b.id"; //where i.e the Book-table publisher id
//					//is the same as the publisher-table id
//		//get your result
//    	ResultSet rs = stmt.executeQuery(query);
//    	//rs is a long list of results side by side 
//		//put the result into your java application until result is empty
//    	List<Bookmark> bookmarkList = new ArrayList<>();
//    	while (rs.next()) {
//    		long id = rs.getLong("id");
//			String title = rs.getString("title");
//			int publicationYear = rs.getInt("publication_year");
//			String publisher = rs.getString("name");		
//			String[] authors = rs.getString("authors").split(",");			
//			int genre_id = rs.getInt("book_genre_id");
//			//BookGenre genre = BookGenre.values()[genre_id];
//			double amazonRating = rs.getDouble("amazon_rating");
//			
//			//Date createdDate = rs.getDate("created_date");
//			//System.out.println("createdDate: " + createdDate);
//			Timestamp timeStamp = rs.getTimestamp(8);
//			//System.out.println("timeStamp: " + timeStamp);
//			//System.out.println("localDateTime: " + timeStamp.toLocalDateTime());
//			
//			//System.out.println("id: " + id + ", title: " + title + ", publication year: " + publicationYear + ", publisher: " + publisher + ", authors: " + String.join(", ", authors) + ", genre: " + ", amazonRating: " + amazonRating);
//    		
//			
//    		Bookmark bookmark = BookmarkManager.getInstance().createBook(id, title, publicationYear, publisher,  amazonRating);
//    		bookmarkList.add(bookmark); 
//    	}
//    	bookmarks.add(bookmarkList);
//    }	

	
	private static void loadUsers(Statement stmt) throws SQLException {		
		//query the database
		String query = "Select *"
				+ " from User u";
		
    	ResultSet rs = stmt.executeQuery(query);
    	//rs is a long list of results side by side 
		//put the result into your java application until result is empty
    	while (rs.next()) {
    		long id = rs.getLong("id");
			String email = rs.getString("email");
			String name = rs.getString("first_name");
			String last_Name = rs.getString("last_Name");		
			int gender_id = rs.getInt("gender_id");	
			
			int user_type_enum_number = rs.getInt("user_type_id");
			
			UserType user_type = UserType.values()[user_type_enum_number];
			
			//UserType user_type_id = UserType.CHIEF_EDITOR
			
			//Date createdDate = rs.getDate("created_date");
			//System.out.println("createdDate: " + createdDate);
			Timestamp timeStamp = rs.getTimestamp(8);
			//System.out.println("timeStamp: " + timeStamp);
			//System.out.println("localDateTime: " + timeStamp.toLocalDateTime());
			
			//System.out.println("id: " + id + ", title: " + email + ", publication year: " + name) ;//, publisher: " + publisher + ", authors: " + String.join(", ", authors) + ", genre: " + ", amazonRating: " + amazonRating);
    		
			
			
			
    		User user = UserManager.getInstance().createUser(id, email, name, last_Name,  gender_id, user_type);
    		users.add(user);
    	}
    	
    }

	
	public static void add(UserBookmark userBookmark) {
		userBookmarks.add(userBookmark);		
	}	

}
