package com.website.bookMarkingApp.entities;

import org.apache.commons.lang3.StringUtils;

import com.website.bookMarkingApp.partner.Shareable;

public class Weblink extends Bookmark implements Shareable{


	public long id;
	private String title;
	public String url;
	private String host;

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
		return url;
	}

	public void setProfileUrl(String url) {
		this.url = url;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}
	
	@Override
	public String toString() {
		return "Weblink [id=" + id + ", title=" + title + ", url=" + url + ", host=" + host + "]";
	}

	@Override
	public boolean isKidFriendlyEligible() {
		
		if(getTitle().contains("porn")|| url.contains("porn")) {
			return false;
		}
		else if(getHost().contains("adult")||getTitle().contains("adult")) {
			return false;
		}
		return true;
		
	}

	@Override
	public String getItemData() {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
				StringBuilder builder =  new StringBuilder();
				builder.append("<item>");
					builder.append("<type>weblink</type>");
					builder.append("<Title>").append(getTitle()).append("</Title>");
					builder.append("<URL>").append(url).append("</URL>");
				builder.append("</item>");
			
		return builder.toString();
	}
	

}
