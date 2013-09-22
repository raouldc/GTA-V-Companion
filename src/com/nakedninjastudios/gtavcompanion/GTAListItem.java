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
	private String points = "None";
	private String trophy = "None";

	public String getPoints() {
		return points;
	}

	public void setPoints(String points) {
		this.points = points;
	}

	public String getTrophy() {
		return trophy;
	}

	public void setTrophy(String trophy) {
		this.trophy = trophy;
	}
	

}
