package com.embibe.musicPlatform.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="Playlist")
@Table(name="playlist")
public class Playlist implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String playlistName;


    @Column(nullable = false)
    private int views;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    @ManyToMany(cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
                })
    @JoinTable(name = "playlist_tags",
            joinColumns = { @JoinColumn(name = "playlist_id") },
            inverseJoinColumns = { @JoinColumn(name = "tags_id") })
    private Set<Tags> tags = new HashSet<>();
    
    public Playlist(User user, Long id, String playlistName, int views) {
        this.user = user;
    	this.id = id;
        this.playlistName = playlistName;
        this.views = views;
    }

    protected Playlist() {

    }

    public Set<Tags> getTags() {
		return tags;
	}

	public void setTags(Set<Tags> tags) {
		this.tags = tags;
	}

	public User getUser() {
    	return user;
    }
    
    public void setUser(User user) {
		this.user = user;
	}

	public Long getId() {
        return id;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public int getViews() {
        return views;
    }

    @Override
    public String toString() {
        return "Playlist " +
                "id=" + id +
                ", playlistName='" + playlistName + '\'' +
                ", views=" + views;
    }
}
