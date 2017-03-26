package com.humegatech.marvelapi;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.humegatech.marvelapi.config.ConnectorConfig;

public class MarvelAPIConnectorTest {

	private MarvelAPIConnector connector;

	@Before
	public void setup() {
		connector = new MarvelAPIConnector();
		connector.config = new ConnectorConfig();
		connector.config.setPublicKey(System.getProperty("MARVEL_KEY"));
		connector.config.setPrivateKey(System.getProperty("MARVEL_SECRET"));
	}

	@After
	public void tearDown() {
		connector = null;
	}

	/*
	 * Functional test cases -- require actual credentials, really call the
	 * Marvel API
	 */
	@Test
	public void testGetComics() {
		String json = connector.getComics();
		System.out.println(json);
	}

}