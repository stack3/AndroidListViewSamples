package net.stack3.listviewsample.model;

import net.stack3.listviewsample.R;

public class CustomListItem implements BaseCustomListItem {
	private String title;
	private String description;
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public int getViewType() {
		return 0;
	}
}
