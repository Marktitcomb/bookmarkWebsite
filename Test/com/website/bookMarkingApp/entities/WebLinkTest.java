package com.website.bookMarkingApp.entities;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.website.bookMarkingApp.managers.BookmarkManager;

class WebLinkTest {

	@Test
	void testIsKidFriendlyEligible() {
		//test 1 porn in URL - return false
		Weblink weblink = BookmarkManager.getInstance().createWeblink(2000, "Taming Tiger",
				"http://www.javaworld.com/article/2072759/core-java/taming-porn--part-2.html", "unknown");
		
		boolean isKindFriendly = weblink.isKidFriendlyEligible();
		assertFalse("For porn in url",isKindFriendly);
		//test2 porn in title - return false
		
		weblink = BookmarkManager.getInstance().createWeblink(2000, "Taming porn",
				"http://www.javaworld.com/article/2072759/core-java/taming-porn--part-2.html", "unknown");
		isKindFriendly = weblink.isKidFriendlyEligible();
		assertFalse("For porn in url 2",isKindFriendly);
		
		//test3 for adult in host
		weblink = BookmarkManager.getInstance().createWeblink(2000, "Taming Tiger",
				"http://www.javaworld.com/article/2072759/core-java/taming-porn--part-2.html", "adult");
		isKindFriendly = weblink.isKidFriendlyEligible();
		assertFalse("For porn in url 3",isKindFriendly);
		//test4 for adult in hostt
		weblink = BookmarkManager.getInstance().createWeblink(2000, "Taming Tiger",
				"http://www.javaworld.com/article/2072759/core-java/taming-porn--part-2.html", "non");
		isKindFriendly = weblink.isKidFriendlyEligible();
		assertFalse("For porn in url 4",isKindFriendly);
		//test5 for porn not in title
		weblink = BookmarkManager.getInstance().createWeblink(2000, "Taming Tiger",
				"http://www.javaworld.com/article/2072759/core-java/taming---part-2.html", "non");
		isKindFriendly = weblink.isKidFriendlyEligible();
		assertTrue("For porn not in url 5",isKindFriendly);
		
	}

}
