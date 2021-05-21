package com.website.bookMarkingApp.entities;

import org.apache.commons.lang3.StringUtils;

import com.website.bookMarkingApp.partner.Shareable;

public class Book extends Bookmark implements Shareable{
	
	private String Author;
	private long id;
	private String title;
	private String publisher;
	private int publishYear;
	private String [] authors;
	private String genre;
	private double amazonRating;
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
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
	public int getPublishYear() {
		return publishYear;
	}
	public void setPublishYear(int publishYear) {
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
	public double getAmazonRating() {
		return amazonRating;
	}
	public void setAmazonRating(double amazonRating) {
		this.amazonRating = amazonRating;
	}
	@Override
	public boolean isKidFriendlyEligible() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public String getItemData() {
		// TODO Auto-generated method stub
		StringBuilder builder =  new StringBuilder();
		builder.append("<item>");
			builder.append("<type>book</type>");
			builder.append("<Title>").append(getTitle()).append("</Title>");
			builder.append("<Publisher>").append(publisher).append("</Publisher>");
			builder.append("<PublicationYear>").append(publishYear).append("</PublicationYear>");
			builder.append("<Genre>").append(genre).append("</Genre>");
			builder.append("<Authors>").append(StringUtils.join(authors, ",")).append("</Authors>");
		builder.append("</item>");
	

		return builder.toString();
	}
	

}
