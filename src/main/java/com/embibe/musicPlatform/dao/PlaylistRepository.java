package com.embibe.musicPlatform.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.embibe.musicPlatform.model.Playlist;

public interface PlaylistRepository extends PagingAndSortingRepository<Playlist, Long> {
	Page<Playlist> findByUserId(Long userId, Pageable pageable);
	
	@Query(value = "select count(*) from playlist p " +
            "group by p.playlist_name ", nativeQuery = true)
    int findCountOfUniquePlaylist();
}
