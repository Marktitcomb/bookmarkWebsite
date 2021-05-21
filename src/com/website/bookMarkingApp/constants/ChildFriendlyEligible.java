package com.website.bookMarkingApp.constants;

public enum ChildFriendlyEligible {
	
	APPROVED("approved"), REJECTED("rejected"), UNKNOWN("unknown");
	
	private ChildFriendlyEligible(String name) {
		this.name = name;
	}
	
	private String name;
	
	public String getName() {
		return name; 
	}

}
