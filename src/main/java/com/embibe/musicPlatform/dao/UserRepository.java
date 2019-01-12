package com.embibe.musicPlatform.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.embibe.musicPlatform.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
