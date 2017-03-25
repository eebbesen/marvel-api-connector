package com.humegatech.marvelapi.client;

import static com.humegatech.marvelapi.client.Entity.CHARACTERS;
import static com.humegatech.marvelapi.client.Entity.COMICS;
import static com.humegatech.marvelapi.client.Entity.CREATORS;
import static com.humegatech.marvelapi.client.Entity.EVENTS;
import static com.humegatech.marvelapi.client.Entity.SERIES;
import static com.humegatech.marvelapi.client.Entity.STORIES;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

public class MarvelAPIClient implements MarvelAPIClientInterface {
	private static final String DEFAULT_URL = "https://gateway.marvel.com:443/v1/public";
	private final String apiKey;
	private final String privateKey;
	private final Client client;

	public MarvelAPIClient(final String apiKey, final String privateKey) {
		this.apiKey = apiKey;
		this.privateKey = privateKey;
		client = ClientBuilder.newClient();
	}

	@Override
	public String getCharacters() {
		return issueGet(CHARACTERS);
	}

	@Override
	public String getComics() {
		return issueGet(COMICS);
	}

	@Override
	public String getCreators() {
		return issueGet(CREATORS);
	}

	@Override
	public String getEvents() {
		return issueGet(EVENTS);
	}

	@Override
	public String getSeries() {
		return issueGet(SERIES);
	}

	@Override
	public String getStories() {
		return issueGet(STORIES);
	}

	/**
	 * Marvel API calls require a unique value (timestamp is what this uses),
	 * the public key and hash of those two plus the private key to be md5
	 * hashed
	 * 
	 * @param path
	 *            Path to use specifying endpoint
	 * @return JSON response
	 */
	private String issueGet(final Entity entity) {
		final String ts = String.valueOf(Calendar.getInstance().getTimeInMillis());

		WebTarget target = client.target(DEFAULT_URL).path(entity.path()).queryParam("apikey", apiKey)
				.queryParam("ts", ts).queryParam("hash", md5(ts));
		Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();

		JSONObject json = new JSONObject(response.readEntity(String.class));

		return json.getJSONObject("data").toString();
	}

	String md5(final String timestamp) {
		MessageDigest digester = null;
		final String toEncode = timestamp + privateKey + apiKey;

		try {
			digester = MessageDigest.getInstance("MD5");
			digester.update(toEncode.getBytes());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return new BigInteger(1, digester.digest()).toString(16);
	}
}
