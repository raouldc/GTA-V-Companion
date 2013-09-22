package com.nakedninjastudios.gtavcompanion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class XMLParser {
	private InputStream is;
	private String type;

	public XMLParser(InputStream is, String t) {

		this.is = is;
		this.type = t;
	}

	public ArrayList<GTAListItem> parseXML() throws XmlPullParserException,
			IOException {

		ArrayList<GTAListItem> courseList = new ArrayList<GTAListItem>();

		// Create XMLPullParser instance
		XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
		factory.setNamespaceAware(true);
		XmlPullParser parser = factory.newPullParser();

		parser.setInput(new BufferedReader(new InputStreamReader(is)));
		GTAListItem listItem = null;
		String text = "";
		int eventType = parser.getEventType();
		int count = 1;
		while (eventType != XmlPullParser.END_DOCUMENT) {
			String tagname = parser.getName();
			switch (eventType) {
			case XmlPullParser.START_TAG:
				if (tagname.equalsIgnoreCase("chapter")) {
					listItem = new GTAListItem();
				}
				break;

			case XmlPullParser.TEXT:
				text = parser.getText();
				break;

			case XmlPullParser.END_TAG:
				if (tagname.equalsIgnoreCase("chapter")) {
					courseList.add(listItem);
				} else if (tagname.equalsIgnoreCase("title")) {
					if (type.equals("walkthrough")) {
						listItem.setTitle("Mission "+count+": "+text);
						count++;
					}
					else{
						listItem.setTitle(text);
					}
				} else if (tagname.equalsIgnoreCase("content")) {
					listItem.setContent(text);
				}
				break;

			default:
				break;
			}
			eventType = parser.next();
		}
		return courseList;
	}
}
