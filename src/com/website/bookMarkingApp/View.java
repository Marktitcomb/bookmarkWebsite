package com.website.bookMarkingApp;

import com.website.bookMarkingApp.controllers.BookmarkController;
import com.website.bookMarkingApp.*;
import com.website.bookMarkingApp.constants.ChildFriendlyEligible;
import com.website.bookMarkingApp.constants.UserType;
import com.website.bookMarkingApp.entities.Bookmark;
import com.website.bookMarkingApp.entities.User;
import com.website.bookMarkingApp.partner.Shareable;

public class View {

	public static void browse(User user, Bookmark[][] bookmarks) {

		System.out.println("\n" + user.getEmail() + " is browsing");
		int lvBookmarkCount = 0;

		//list over all bookmarks 
		for (Bookmark[] bookmarkList : bookmarks) {
			for (Bookmark bookmark : bookmarkList) {

				//creates a new bookmark at random -> getBookmarkDecision
				if (lvBookmarkCount < DataStore.USER_BOOKMARK_LIMIT) {
					boolean isBookmarked = getBookmarkDecision(bookmark);
					if (isBookmarked) {
						lvBookmarkCount++;
						BookmarkController.getInstance().saveUserBookmark(user, bookmark);

						System.out.print("NEw item Bookmarked " + bookmark);
					}
				}
				//determines if user is editor then makes a decision at random 
				if (user.getUserType().equals(UserType.CHIEF_EDITOR) || user.getUserType().equals(UserType.EDITOR)) {
					// mark kid friendly
					//makes sure not inappropriate
					if (bookmark.isKidFriendlyEligible() && 
							bookmark.getIsKidFriendlyEligible().equals(ChildFriendlyEligible.UNKOWN) ) {

						//then decision at random 
						String childFriendlyStatus = getKidFriendlyStatusDecision(bookmark);
						if(!childFriendlyStatus.equals(ChildFriendlyEligible.UNKOWN)) {
							//get the controller
							//get the manager
							//to set
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
		return Math.random() < 0.5 ? true : false;
	}

	private static String getKidFriendlyStatusDecision(Bookmark bookmark) {
		// TODO Auto-generated method stub
		return Math.random() < 0.4 ? ChildFriendlyEligible.APPROVED : 
			Math.random() > 0.4 && Math.random() < 0.8 ? ChildFriendlyEligible.DENIED:
				ChildFriendlyEligible.UNKOWN;
	}

	private static boolean getBookmarkDecision(Bookmark bookmark) {
		return Math.random() < 0.5 ? true : false;
	}
}
