package com.embibe.musicPlatform.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.embibe.musicPlatform.dao.PlaylistRepository;
import com.embibe.musicPlatform.dao.TagsRepository;
import com.embibe.musicPlatform.dao.UserRepository;
import com.embibe.musicPlatform.exception.ResourceNotFoundException;
import com.embibe.musicPlatform.model.AutoSuggestTag;
import com.embibe.musicPlatform.model.Playlist;
import com.embibe.musicPlatform.model.Tags;
import com.embibe.musicPlatform.model.User;

@Component
public class MusicPlatformService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PlaylistRepository playlistRepository;
	
	@Autowired
	private TagsRepository tagsRepository;
	
	public User saveUser(User user) {
		return userRepository.save(user);
    }

	public Playlist savePlaylist(Long userId, Playlist playlist) {
		return userRepository.findById(userId).map(user ->{ 
			playlist.setUser(user);
			return playlistRepository.save(playlist);
		}).orElseThrow(() -> new ResourceNotFoundException("UserId " + userId + " not found"));
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	public Page<Playlist> getAllPlaylist(Long userId, Pageable pageable) {
		return playlistRepository.findByUserId(userId, pageable);
	}

	public int getPlayUnique() {
		return playlistRepository.findCountOfUniquePlaylist();
	}

	public Tags saveTags(Long playlistId, Tags tags) {
//		return playlistRepository.findById(playlistId).map(playlist ->{ 
//			tags.getPlaylist().add(playlist);
//			return playlistRepository.save(tags);
//		}).orElseThrow(() -> new ResourceNotFoundException("UserId " + playlistId + " not found"));
		Playlist playlist = playlistRepository.findById(playlistId).orElse(null);
		
		if (playlist != null) {
			System.out.println(playlist.toString());
			tags.getPlaylist().add(playlist);
			playlist.getTags().add(tags);
			System.out.println(tags.toString());
			playlistRepository.save(playlist);
			
			return tagsRepository.findBytagName(tags.getTagName());
			//return tagsRepository.findAll();
			//tagsRepository.save(tags);
			//tagsRepository.findby
			//return tags;
		} else {
			throw new ResourceNotFoundException("PlaylistId " + playlistId + " not found");
		}
	}

	
	public List<Tags> backupSaveTags(Long playlistId, Tags tags) {
//		return playlistRepository.findById(playlistId).map(playlist ->{ 
//			tags.getPlaylist().add(playlist);
//			return playlistRepository.save(tags);
//		}).orElseThrow(() -> new ResourceNotFoundException("UserId " + playlistId + " not found"));
		Playlist playlist = playlistRepository.findById(playlistId).orElse(null);
		
		if (playlist != null) {
			System.out.println(playlist.toString());
			tags.getPlaylist().add(playlist);
			List<Tags> taglist = tagsRepository.findAll();
			boolean foundTag = false;
			for (Tags t: taglist) {
				if (tags.getTagName().equalsIgnoreCase(t.getTagName())) {
					playlist.getTags().add(t);
					foundTag = true;
				}
			}
			if (!foundTag) {
				playlist.getTags().add(tags);
			}
			System.out.println(tags.toString());
			playlistRepository.save(playlist);
			return tagsRepository.findAll();
			//tagsRepository.save(tags);
			//tagsRepository.findby
			//return tags;
		} else {
			throw new ResourceNotFoundException("PlaylistId " + playlistId + " not found");
		}
	}
	public List<Tags> getTagsForAPlaylist(Long playlistId) {
		return tagsRepository.findByPlaylistId(playlistId);
	}

	public List<AutoSuggestTag> autoSuggestTags(String inputTagName) {
		tagsRepository.autoSuggestTags(inputTagName);
		return null;
	}
}
