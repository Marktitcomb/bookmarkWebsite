package com.website.bookMarkingApp.entities;

import com.website.bookMarkingApp.constants.ChildFriendlyEligible;

public abstract class Bookmark {

	private long id;
	private String title;
	private String profileUrl;
	private ChildFriendlyEligible isKidFriendlyEligible;// = ChildFriendlyEligible.UNKNOWN;
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

	public ChildFriendlyEligible getIsKidFriendlyEligible() {
		return isKidFriendlyEligible;
	}

	public void setKidFriendlyEligible(ChildFriendlyEligible isKidFriendlyEligible) {
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
		return "Bookmark [id=" + getId() + ", title=" + this.getTitle() + ", profileUrl=" + this.getProfileUrl()  + "]";
	}

	public abstract boolean isKidFriendlyEligible();

}
