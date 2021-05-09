package com.website.bookMarkingApp.entities;

import com.website.bookMarkingApp.constants.ChildFriendlyEligible;

public abstract class Bookmark {

	private long id;
	private String title;
	private String profileUrl;
	private String isKidFriendlyEligible = ChildFriendlyEligible.UNKOWN;
	private User childFriendlyMarkedBY;
	private User sharedBy;

	/**
	 * @return the sharedBy
	 */
	public User getSharedBy() {
		return sharedBy;
	}

	/**
	 * @param sharedBy the sharedBy to set
	 */
	public void setSharedBy(User sharedBy) {
		this.sharedBy = sharedBy;
	}

	public User getChildFriendlyMarkedBY() {
		return childFriendlyMarkedBY;
	}

	public void setChildFriendlyMarkedBY(User childFriendlyMarkedBY) {
		this.childFriendlyMarkedBY = childFriendlyMarkedBY;
	}

	public String getIsKidFriendlyEligible() {
		return isKidFriendlyEligible;
	}

	public void setIsKidFriendlyEligible(String isKidFriendlyEligible) {
		this.isKidFriendlyEligible = isKidFriendlyEligible;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getProfileUrl() {
		return profileUrl;
	}

	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
	}

	@Override
	public String toString() {
		return "Bookmark [id=" + id + ", title=" + title + ", profileUrl=" + profileUrl + "]";
	}

	public abstract boolean isKidFriendlyEligible();

}
