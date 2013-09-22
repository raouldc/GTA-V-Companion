package com.nakedninjastudios.gtavcompanion;

public class GTAListItem {
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String toString()
	{
		return title;
	}

	private String content,title;
	

}
