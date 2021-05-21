package com.website.bookMarkingApp;

import com.website.bookMarkingApp.controllers.BookmarkController;

import java.sql.SQLException;
import java.util.List;

import com.website.bookMarkingApp.*;
import com.website.bookMarkingApp.constants.ChildFriendlyEligible;
import com.website.bookMarkingApp.constants.UserType;
import com.website.bookMarkingApp.entities.Bookmark;
import com.website.bookMarkingApp.entities.User;
import com.website.bookMarkingApp.partner.Shareable;

public class View {
	
	
	//********************FAKE CLASS***********************************//
	
	// This is just used to randomly represent what a user may be doing 
	// whilst using a web application 
	
	
	//******************************************************************
	

	public static void browse(User user, List<List<Bookmark>> bookmarks) throws SQLException {

		System.out.println("\n" + user.getEmail() + " is browsing");
		int lvBookmarkCount = 0;
		final int USER_BOOKMARK_LIMIT = 5;

		//list over all bookmarks 
		for (List<Bookmark> bookmarkList : bookmarks) {
			for (Bookmark bookmark : bookmarkList) {

				//creates a new bookmark at random -> getBookmarkDecision
				if (lvBookmarkCount < USER_BOOKMARK_LIMIT) {
					boolean isBookmarked = getBookmarkDecision(bookmark);
					if (isBookmarked) {
						lvBookmarkCount++;
						BookmarkController.getInstance().saveUserBookmark(user, bookmark);

						System.out.println("NEw item Bookmarked " + bookmark.toString());
					}
				}
				//determines if user is editor then makes a decision at random 
				if (user.getUserType().equals(UserType.CHIEF_EDITOR) || user.getUserType().equals(UserType.EDITOR)) {
					// mark kid friendly
					//makes sure not inappropriate
					if (bookmark.isKidFriendlyEligible() && 
							bookmark.getIsKidFriendlyEligible().equals(ChildFriendlyEligible.UNKNOWN) ) {

						//then decision at random 
						ChildFriendlyEligible childFriendlyStatus = getKidFriendlyStatusDecision(bookmark);
						if(!childFriendlyStatus.equals(ChildFriendlyEligible.UNKNOWN)) {
							//get the controller
							//get the manager
							//to set
							System.out.println("going in controller");
							BookmarkController.getInstance().setIsKidFriendlyEligible(user, childFriendlyStatus, bookmark);
							
						}
					}
					//random get share decision 
					//sharing, can only share if editor, and if bookmark is of shareable type 
					if(bookmark.getIsKidFriendlyEligible().equals(ChildFriendlyEligible.APPROVED) && bookmark instanceof Shareable) {
						boolean toShare = getSharedDecision();
						if(toShare) {
							BookmarkController.getInstance().shareBookmark(user, bookmark); 
							
						}
					}

				}
				
			}
		}

	}

	private static boolean getSharedDecision() {
		// TODO Auto-generated method stub
		return Math.random() < 0.9 ? true : false;
	}

	private static ChildFriendlyEligible getKidFriendlyStatusDecision(Bookmark bookmark) {
		// TODO Auto-generated method stub
		return ChildFriendlyEligible.APPROVED;
//		return Math.random() < 0.9 ? ChildFriendlyEligible.APPROVED : 
//			Math.random() > 0.4 && Math.random() < 0.8 ? ChildFriendlyEligible.REJECTED:
//				ChildFriendlyEligible.UNKNOWN;
	}

	private static boolean getBookmarkDecision(Bookmark bookmark) {
		return Math.random() < 0.9 ? true : false;
	}
}
