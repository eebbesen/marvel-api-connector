package com.humegatech.marvelapi.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.security.NoSuchAlgorithmException;

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
	}

	@Test
	public void testMd5() throws NoSuchAlgorithmException {
		client = new MarvelAPIClient("8", "to");
		assertEquals("e1cc8f65af55b2f36af47020aa94f5fe", client.md5("1"));
		// $ md5 -s 1to8
		// MD5 ("1to8") = e1cc8f65af55b2f36af47020aa94f5fe
	}

	/*
	 * Functional test cases -- requires actual credentials, really calls the
	 * Marvel API
	 */

	@Test
	public void testGetCharacters() throws NoSuchAlgorithmException {
		String json = client.getCharacters();
		System.out.println(json);
		assertTrue(json, json.contains("name"));
	}

	@Test
	public void testGetComics() throws NoSuchAlgorithmException {
		String json = client.getComics();
		System.out.println(json);
		assertTrue(json, json.contains("digitalId"));
	}

	@Test
	public void testGetCreators() throws NoSuchAlgorithmException {
		String json = client.getCreators();
		System.out.println(json);
		assertTrue(json, json.contains("middleName"));
	}

	@Test
	public void testGetEvents() throws NoSuchAlgorithmException {
		String json = client.getEvents();
		System.out.println(json);
		assertTrue(json, json.contains("previous"));
	}

	@Test
	public void testGetSeries() throws NoSuchAlgorithmException {
		String json = client.getSeries();
		System.out.println(json);
		assertTrue(json, json.contains("rating"));
	}

	@Test
	public void testGetStories() throws NoSuchAlgorithmException {
		String json = client.getStories();
		System.out.println(json);
		assertTrue(json, json.contains("originalIssue"));
	}
}
