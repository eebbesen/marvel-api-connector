package com.humegatech.marvelapi.client;

public enum Entity {
	CHARACTERS("characters"), COMICS("comics"), CREATORS("creators"), EVENTS("events"), SERIES("series"), STORIES(
			"stories");

	private final String path;

	private Entity(final String path) {
		this.path = path;
	}

	public String path() {
		return path;
	}
}
