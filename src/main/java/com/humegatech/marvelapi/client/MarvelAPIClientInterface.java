package com.humegatech.marvelapi.client;

/**
 * See https://developer.marvel.com/documentation/entity_types
 * 
 * @author eebbesen
 *
 */
public interface MarvelAPIClientInterface {
	public String getCharacters();

	public String getComics();

	public String getCreators();

	public String getEvents();

	public String getSeries();

	public String getStories();
}
