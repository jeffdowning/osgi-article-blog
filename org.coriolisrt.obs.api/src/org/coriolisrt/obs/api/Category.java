package org.coriolisrt.obs.api;

import java.util.ArrayList;
import java.util.List;

public class Category {
	private String name;
	private List<String> tags;
	
	public Category(){
		tags = new ArrayList<String>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addTag(String tag){
		this.tags.add(tag);
	}
	
	public void removeTag(String tag){
		this.tags.remove(tag);
	}
}
