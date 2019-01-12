package com.embibe.musicPlatform.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.embibe.musicPlatform.model.AutoSuggestTag;
import com.embibe.musicPlatform.model.Tags;

public interface TagsRepository extends JpaRepository<Tags, Long> {

	List<Tags> findByPlaylistId(Long playlistId);
	
	Tags findBytagName(String tagName);

	 @Query(value = "select count(p.id), t.tag_name  from playlist p, " +
	            " tags t, playlist_tags pt " +
	                "where p.id = pt.playlist_id " +
	                "and t.id = pt.tags_id " +
	            "group by t.id " +
	            "having t.tag_name like ?#{[0]}" + "%", nativeQuery = true)

	 List<AutoSuggestTag> autoSuggestTags(String inputTagName);
}
