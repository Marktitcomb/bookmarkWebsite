package com.website.bookMarkingApp.constants;

public enum UserType {
	
	User(0), EDITOR(1), CHIEF_EDITOR(2);
	
	private UserType(int value) {
		this.value = value;
	}
	
	private int value;
	
	public int getType() {
		return value;
	}

	
}

