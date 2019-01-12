package com.embibe.musicPlatform.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Tags implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String tagName;
    
    @ManyToMany(
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            },
            mappedBy = "tags")
    private Set<Playlist> playlist = new HashSet<>();
    @JsonIgnore
    public Tags(Long id, String tagName) {
    	this.id = id;
        this.tagName = tagName;
    }

    protected Tags() {

    }

	public Set<Playlist> getPlaylist() {
		return playlist;
	}

	public void setPlaylist(Set<Playlist> playlist) {
		this.playlist = playlist;
	}

	public Long getId() {
        return id;
    }

    public String getTagName() {
		return tagName;
	}

	@Override
    public String toString() {
        return "Tags " +
                "id=" + id +
                ", tagName='" + tagName;
    }
}
