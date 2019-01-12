package com.embibe.musicPlatform.model;

import java.io.Serializable;

public class AutoSuggestTag implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String tagName;
	
	private long playlistCount;

	public AutoSuggestTag(Long playlistCount, String tagName) {
		this.tagName = tagName;
		this.playlistCount = playlistCount;
	}
	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public Long getPlaylistCount() {
		return playlistCount;
	}

	public void setPlaylistCount(Long playlistCount) {
		this.playlistCount = playlistCount;
	}

}
