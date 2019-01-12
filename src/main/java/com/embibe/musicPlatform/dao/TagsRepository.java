package com.embibe.musicPlatform.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.embibe.musicPlatform.model.AutoSuggestTag;
import com.embibe.musicPlatform.model.Tags;

public interface TagsRepository extends JpaRepository<Tags, Long> {

	List<Tags> findByPlaylistId(Long playlistId);
	
	Tags findBytagName(String tagName);

//	 @Query(value = "select new com.embibe.musicPlatform.model.AutoSuggestTag(count(p.id) playlistCount, t.tag_name tagName) from playlist p, " +
//	            " tags t, playlist_tags pt " +
//	                "where p.id = pt.playlist_id " +
//	                "and t.id = pt.tags_id " +
//	            "group by t.id " +
//	            "having t.tag_name like ?#{[0]}" + "%", nativeQuery = true)
	 @Query(value = "SELECT new com.embibe.musicPlatform.model.AutoSuggestTag(count(p.id) as playlistCount, t.tagName as tagName) FROM  " +
    "  Playlist as p JOIN p.tags t " +
			// "where t.id = playlist_tags.tags_id and p.id = playlist_tags.playlist_id" + 
    " group by t.id " +
    "having t.tagName like ?1%" )
	 List<AutoSuggestTag> autoSuggestTags(String inputTagName);
}
