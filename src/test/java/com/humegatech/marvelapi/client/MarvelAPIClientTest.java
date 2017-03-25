package com.humegatech.marvelapi.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.security.NoSuchAlgorithmException;

import org.junit.After;
import org.junit.Test;

public class MarvelAPIClientTest {
	private MarvelAPIClient client;

	@After
	public void tearDown() {
		client = null;
	}

	/*
	 * Functional test case -- requires actual credentials, really calls the
	 * Marvel API
	 */
	@Test
	public void testGetCharacters() throws NoSuchAlgorithmException {
		client = new MarvelAPIClient(System.getProperty("MARVEL_KEY"), System.getProperty("MARVEL_SECRET"));
		String json = client.getCharacters();
		System.out.println(json);
		assertTrue(json, json.contains("name"));
	}
	
	/*
	 * Functional test case -- requires actual credentials, really calls the
	 * Marvel API
	 */
	@Test
	public void testGetComics() throws NoSuchAlgorithmException {
		client = new MarvelAPIClient(System.getProperty("MARVEL_KEY"), System.getProperty("MARVEL_SECRET"));
		String json = client.getComics();
		System.out.println(json);
		assertTrue(json, json.contains("digitalId"));
	}

	@Test
	public void testMd5() throws NoSuchAlgorithmException {
		client = new MarvelAPIClient("8", "to");
		assertEquals("e1cc8f65af55b2f36af47020aa94f5fe", client.md5("1"));
		// $ md5 -s 1to8
		// MD5 ("1to8") = e1cc8f65af55b2f36af47020aa94f5fe
	}
}
