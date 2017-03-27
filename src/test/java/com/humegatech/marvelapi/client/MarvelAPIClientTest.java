package com.humegatech.marvelapi.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class MarvelAPIClientTest {
	private MarvelAPIClient client;

	@Before
	public void setup() {
		client = new MarvelAPIClient(System.getProperty("MARVEL_KEY"), System.getProperty("MARVEL_SECRET"));
	}

	@After
	public void tearDown() {
		client = null;
	}

	@Test
	public void testMd5() {
		client = new MarvelAPIClient("8", "to");
		assertEquals("e1cc8f65af55b2f36af47020aa94f5fe", client.md5("1"));
		// $ md5 -s 1to8
		// MD5 ("1to8") = e1cc8f65af55b2f36af47020aa94f5fe
	}

	@Test
	public void testResponseFromMarvelUnauthorized401() {
		final String json = "{\"code\":\"InvalidCredentials\",\"message\":\"That hash, timestamp and key combination is invalid.\"}";
		final JSONObject expectedJson = new JSONObject(json);

		Response mockResponse = mock(Response.class);
		Mockito.when(mockResponse.getStatus()).thenReturn(401);
		Mockito.when(mockResponse.readEntity(String.class)).thenReturn(json);

		client = new MarvelAPIClient("public", "private");
		MarvelAPIClient spyClient = Mockito.spy(client);
		Mockito.doReturn(mockResponse).when(spyClient).execute(Mockito.any(WebTarget.class));

		JSONObject returnedJson = new JSONObject(spyClient.getCharacters());

		for (String key : expectedJson.keySet()) {
			assertEquals(expectedJson.get(key), returnedJson.get(key));
		}
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
