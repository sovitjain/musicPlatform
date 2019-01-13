package com.embibe.musicPlatform.model;

import java.io.Serializable;

public class DisplaySuggestedTags implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String tagName;
	
	public DisplaySuggestedTags(String tagName) {
		this.tagName = tagName;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

}
