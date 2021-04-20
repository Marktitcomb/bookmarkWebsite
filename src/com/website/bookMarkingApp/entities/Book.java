package com.website.bookMarkingApp.entities;

public class Book {
	
	private String Author;
	
	private String publisher;
	private String publishYear;
	private String [] authors;
	private String genre;
	private String amazonRating;
	
	
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getPublishYear() {
		return publishYear;
	}
	public void setPublishYear(String publishYear) {
		this.publishYear = publishYear;
	}
	public String[] getAuthors() {
		return authors;
	}
	public void setAuthors(String[] authors) {
		this.authors = authors;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getAmazonRating() {
		return amazonRating;
	}
	public void setAmazonRating(String amazonRating) {
		this.amazonRating = amazonRating;
	}
	

}
