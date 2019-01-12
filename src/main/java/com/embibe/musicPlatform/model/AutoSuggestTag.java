package com.embibe.musicPlatform.model;

import java.io.Serializable;

public class AutoSuggestTag implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String tagName;
	
	private int playlistCount;

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public int getPlaylistCount() {
		return playlistCount;
	}

	public void setPlaylistCount(int playlistCount) {
		this.playlistCount = playlistCount;
	}

}
