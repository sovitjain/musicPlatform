package com.embibe.musicPlatform.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.embibe.musicPlatform.model.AutoSuggestTag;
import com.embibe.musicPlatform.model.DisplaySuggestedTags;
import com.embibe.musicPlatform.model.Playlist;
import com.embibe.musicPlatform.model.Tags;
import com.embibe.musicPlatform.model.User;
import com.embibe.musicPlatform.service.MusicPlatformService;

@RestController
public class MusicPlatformController{

	@Autowired
	private MusicPlatformService musicPlatformService;
	
	@PostMapping("/user")
	public User saveUser(@RequestBody User user) {
		return musicPlatformService.saveUser(user);
    }
	
	@PostMapping("/user/{userId}/playlist")
	public Playlist savePlaylist(@PathVariable (value = "userId") Long userId,
			@RequestBody Playlist playlist) {
		return musicPlatformService.savePlaylist(userId, playlist);
    }
	
	@PostMapping("/playlist/{playlistId}/tags")
	public Tags saveTags(@PathVariable (value = "playlistId") Long playlistId,
			@RequestBody Tags tags) {
		return musicPlatformService.saveTags(playlistId, tags);
    }

	@GetMapping("/user")
	public List<User> getAllUser() {
		return musicPlatformService.getAllUsers();
	}
	
	@GetMapping("/user/{userId}/playlist")
	public Page<Playlist> getAllPlaylist(@PathVariable (value = "userId") Long userId, Pageable pageable) {
		return musicPlatformService.getAllPlaylist(userId, pageable);
	}
	
	@GetMapping("/playlist/{playlistId}/tags")
	public List<Tags> getTagsForAPlaylist(@PathVariable (value = "playlistId") Long playlistId, Pageable pageable) {
		return musicPlatformService.getTagsForAPlaylist(playlistId);
	}
	
	@GetMapping("/playlistUnique")
	public int getPlayUnique() {
		return musicPlatformService.getPlayUnique();
	}
	
	@GetMapping("/autoSuggestTags")
	public List<AutoSuggestTag> autoSuggestTags(@RequestParam String inputTagName) {
		return musicPlatformService.autoSuggestTags(inputTagName);
	}
	
	@GetMapping("/displaySuggestedTags")
	public List<DisplaySuggestedTags> displaySuggestedTags(@RequestParam String inputTagName) {
		return musicPlatformService.displaySuggestedTags(inputTagName);
	}
}

