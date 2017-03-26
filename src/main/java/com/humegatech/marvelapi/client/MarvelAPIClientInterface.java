package com.humegatech.marvelapi.client;

import java.util.Map;

/**
 * See https://developer.marvel.com/documentation/entity_types
 * 
 * @author eebbesen
 *
 */
public interface MarvelAPIClientInterface {
	public String getCharacters();

	public String getCharacters(Map params);

	public String getComics();

	public String getComics(Map params);

	public String getCreators();

	public String getCreators(Map params);

	public String getEvents();

	public String getEvents(Map params);

	public String getSeries();

	public String getSeries(Map params);

	public String getStories();

	public String getStories(Map params);
}
