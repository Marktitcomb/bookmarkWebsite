package com.website.bookMarkingApp.dao;

import java.util.List;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.website.bookMarkingApp.DataStore;
import com.website.bookMarkingApp.entities.*;
import com.website.bookMarkingApp.entities.Bookmark;
import com.website.bookMarkingApp.entities.UserBookmark;
import com.website.bookMarkingApp.constants.*;

public class BookmarkDao {
	
	public int index; 
	public String url = "jdbc:mysql://localhost:3306/bookmarkingAppDB?useSSL=false";
	public String user = "root";
	public String password = "Guitar0903";

	public List<List<Bookmark>> getBookmarks(){
		
		return DataStore.getBookmarks();
		
	}

	public void saveUserBookmark(UserBookmark userBookmark) {
		//DataStore.add(userBookmark);
		
		//using try with resourcesw here so we dont need to worry about the close methods 
		// for conn or statement 
		
		
		try (Connection conn = DriverManager.getConnection(url, user, password);
				Statement stmt = conn.createStatement();
				) {
			if(userBookmark.getBookmark() instanceof Book) {
				saveUserBook(userBookmark, stmt); 
				System.out.println("Book Saved to DB");
			}
			else if(userBookmark.getBookmark() instanceof Weblink) {
				saveUserWeblink(userBookmark, stmt); 
				System.out.println("Weblink Saved to DB");
			}
			else if(userBookmark.getBookmark() instanceof Movie) {
				saveUserMovie(userBookmark, stmt); 
				System.out.println("Movie Saved to DB");	
			}
			
				
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}

	private void saveUserMovie(UserBookmark userBookmark, Statement stmt) throws SQLException{
		//user_movie table specifies the movies that the user has chosen to bookmark therefore
		// it sits between the two 
		
		String query = "insert into User_Movie (user_id, movie_id) values (" + 
				userBookmark.getUser().getId() + ", " + userBookmark.getBookmark().getId()
				+ ")";
			//execute update because you're inserting/updating the DB
			stmt.executeUpdate(query);
			
		}

	private void saveUserWeblink(UserBookmark userBookmark, Statement stmt) throws SQLException{
		String query = "insert into User_Weblink(user_id, weblink_id) values (" + 
				userBookmark.getUser().getId() + ", " + userBookmark.getBookmark().getId()
				+ ")";
			//execute update because you're inserting/updating the DB
			stmt.executeUpdate(query);
			
		}

	private void saveUserBook(UserBookmark userBookmark, Statement stmt) throws SQLException {
		String query = "insert into User_book (user_id, book_id) values (" +
			userBookmark.getUser().getId() + ", " + userBookmark.getBookmark().getId()
			+ ");";
		//execute update because you're inserting/updating the DB
		stmt.executeUpdate(query);
		
	}

	public void updateKidFriendlyStatus(Bookmark bookmark) throws SQLException{
		//ordinal gives a value to the enumm number 
		//ie approved has value of 0 rejected has a value of 1 
		int kidFriendlyStatus = bookmark.getIsKidFriendlyEligible().ordinal();
		long userID = bookmark.getChildFriendlyMarkedBY().getId();
		
		String tableToUpdate = "Book"; 
		if(bookmark instanceof Movie) {
			tableToUpdate = "Movie";
		}
		else if(bookmark instanceof Weblink) {
			tableToUpdate = "Weblink";
		}
	
		
		try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmarkingAppDB?useSSL=false", "root", "Guitar0903");
			Statement stmt = conn.createStatement();){
				
				String query = "update " + tableToUpdate + " set kid_friendly_status = " + kidFriendlyStatus;
				
				stmt.execute(query);
			
			}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void shareByInfo(Bookmark bookmark) {
		long userId = bookmark.getSharedBy().getId();
		
		String tableToUpdate = "book";
		if(bookmark instanceof Weblink) {
			tableToUpdate = "weblink";
		}
		
		try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmarkingAppDB?useSSL=false", "root", "Guitar0903");
				Statement stmt = conn.createStatement();){
			
			String query = "update " + tableToUpdate + " set shared_by = " + userId + " Where id = " + bookmark.getId() + ";";
			System.out.println("query (updateChild FriendlyStatus): " + query);
			stmt.executeUpdate(query);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
}
