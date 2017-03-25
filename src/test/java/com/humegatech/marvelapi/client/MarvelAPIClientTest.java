package com.humegatech.marvelapi.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MarvelAPIClientTest {
	private MarvelAPIClient client;

	@Before
	public void setUp() {
		client = new MarvelAPIClient(System.getProperty("MARVEL_KEY"), System.getProperty("MARVEL_SECRET"));
	}

	@After
	public void tearDown() {
		client = null;

		// Hate to do it but having some issues with too quick calling
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testMd5() {
		client = new MarvelAPIClient("8", "to");
		assertEquals("e1cc8f65af55b2f36af47020aa94f5fe", client.md5("1"));
		// $ md5 -s 1to8
		// MD5 ("1to8") = e1cc8f65af55b2f36af47020aa94f5fe
	}

	/*
	 * Functional test cases -- require actual credentials, really call the
	 * Marvel API
	 */

	@Test
	public void testGetCharacters() {
		String json = client.getCharacters();
		assertTrue(json, json.contains("name"));
	}

	@Test
	public void testGetCharactersWithParamsEntityId() {
		Map hash = new HashMap();
		hash.put("characterId", 1009372);
		String json = client.getCharacters(hash);
		assertTrue(json, json.contains("J. Jonah Jameson"));
	}

	@Test
	public void testGetCharactersWithParamsString() {
		Map hash = new HashMap();
		hash.put("nameStartsWith", "Uatu");
		String json = client.getCharacters(hash);
		assertTrue(json, json.contains("Uatu The Watcher"));
	}

	@Test
	public void testGetCharactersWithParamsNumeric() {
		Map hash = new HashMap();
		hash.put("series", 3695);
		String json = client.getCharacters(hash);
		assertTrue(json, json.contains("Wonder"));
	}

	@Test
	public void testGetComics() {
		String json = client.getComics();
		assertTrue(json, json.contains("digitalId"));
	}

	@Test
	public void testGetCreators() {
		String json = client.getCreators();
		assertTrue(json, json.contains("middleName"));
	}

	@Test
	public void testGetEvents() {
		String json = client.getEvents();
		assertTrue(json, json.contains("previous"));
	}

	@Test
	public void testGetSeries() {
		String json = client.getSeries();
		assertTrue(json, json.contains("rating"));
	}

	@Test
	public void testGetSeriesWithParamsDateString() {
		Map hash = new HashMap();
		hash.put("modifiedSince", "2017-01-01");
		hash.put("titleStartsWith", "A-Force");
		String json = client.getSeries(hash);
		System.out.println(json);
		assertTrue(json, json.contains("A-Force"));
	}

	@Test
	public void testGetStories() {
		String json = client.getStories();
		assertTrue(json, json.contains("originalIssue"));
	}
}
