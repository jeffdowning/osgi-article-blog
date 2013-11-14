package org.coriolisrt.obs.api;

import java.util.ArrayList;
import java.util.List;

public class Article {
	private int id;
	private String canonicalName;
	private String headline;
	private String description;
	private String body;
	private String author;
	private String authorTitle;
	private String dateline;
	private String location;
	private List<String> tags;
	
	public Article(){
		tags = new ArrayList<String>();
	}
	
	public Article(int dbid){
		this.id = dbid;
	}
	
	public int getId() {
		return id;
	}

	public String getCanonicalName() {
		return canonicalName;
	}

	public void setCanonicalName(String canonicalName) {
		this.canonicalName = canonicalName;
	}

	public String getHeadline() {
		return headline;
	}
	public void setHeadline(String headline) {
		this.headline = headline;
		String canon = headline.toLowerCase().replace(' ', '_').substring(0, 50);
		this.canonicalName = canon;
		
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getAuthorTitle() {
		return authorTitle;
	}
	public void setAuthorTitle(String authorTitle) {
		this.authorTitle = authorTitle;
	}
	public String getDateline() {
		return dateline;
	}
	public void setDateline(String dateline) {
		this.dateline = dateline;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public List<String> getTags(){
		return tags;
	}
	
	public void addTag(String tag){
		this.tags.add(tag);
	}
	
	public void removeTag(String tag){
		this.tags.remove(tag);
	}

}
