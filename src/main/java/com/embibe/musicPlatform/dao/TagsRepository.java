package com.embibe.musicPlatform.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.embibe.musicPlatform.model.AutoSuggestTag;
import com.embibe.musicPlatform.model.DisplaySuggestedTags;
import com.embibe.musicPlatform.model.Tags;

public interface TagsRepository extends JpaRepository<Tags, Long> {

	List<Tags> findByPlaylistId(Long playlistId);
	
	Tags findBytagName(String tagName);

	 @Query(value = "SELECT new com.embibe.musicPlatform.model.AutoSuggestTag(count(p.id) as playlistCount, t.tagName as tagName) FROM  " +
		    "  Playlist as p JOIN p.tags t " + 
		    " group by t.id " +
		    "having t.tagName like ?1%" +
		    "order by count(p.id) desc")
	 List<AutoSuggestTag> autoSuggestTags(String inputTagName);

	 @Query(value = "SELECT new com.embibe.musicPlatform.model.DisplaySuggestedTags(t.tagName as tagName) " +
			 		 " FROM Playlist as p JOIN p.tags t " +
			 		 " WHERE p.id in (" + 
			 		 	"SELECT p.id FROM  " +
			 		 	"Playlist as p JOIN p.tags t " + 
			    		" where t.tagName = ?1) " +
			 		 	"group by t.tagName order by count(t.tagName) desc")
	 List<DisplaySuggestedTags> displaySuggestedTags(String inputTagName);
}
