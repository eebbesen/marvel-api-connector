package com.humegatech.marvelapi.client;

public enum Entity {
	CHARACTERS("characters", "characterId"), COMICS("comics", "comicId"), CREATORS("creators",
			"creatorId"), EVENTS("events", "eventId"), SERIES("series", "seriesId"), STORIES("stories", "storyId");

	private final String path;
	private final String entityIdName;

	private Entity(final String path, final String entityIdName) {
		this.path = path;
		this.entityIdName = entityIdName;
	}

	public String path() {
		return path;
	}

	public String entityIdName() {
		return entityIdName;
	}
}
