package com.embibe.musicPlatform.exception;

public class ResourceNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4347314698324298126L;

	public ResourceNotFoundException(String string) {
		super("Could not find employee " + string);
	}
}
