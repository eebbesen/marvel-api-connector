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
import java.util.Map;
import java.util.Set;

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
		return issueGet(CHARACTERS, null);
	}

	@Override
	public String getCharacters(Map params) {
		return issueGet(CHARACTERS, params);
	}

	@Override
	public String getComics() {
		return issueGet(COMICS, null);
	}

	@Override
	public String getComics(Map params) {
		return issueGet(COMICS, params);
	}

	@Override
	public String getCreators() {
		return issueGet(CREATORS, null);
	}

	@Override
	public String getCreators(Map params) {
		return issueGet(CREATORS, params);
	}

	@Override
	public String getEvents() {
		return issueGet(EVENTS, null);
	}

	@Override
	public String getEvents(Map params) {
		return issueGet(EVENTS, params);
	}

	@Override
	public String getSeries() {
		return issueGet(SERIES, null);
	}

	@Override
	public String getSeries(Map params) {
		return issueGet(SERIES, params);
	}

	@Override
	public String getStories() {
		return issueGet(STORIES, null);
	}

	@Override
	public String getStories(Map params) {
		return issueGet(STORIES, params);
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
	private String issueGet(final Entity entity, Map params) {
		String path = buildPath(entity, params);

		WebTarget target = addParams(client.target(DEFAULT_URL).path(path), params);
		Response response = execute(target);
		JSONObject json = new JSONObject(response.readEntity(String.class));

		if (response.getStatus() != 200) {
			return json.toString();
		}

		return json.getJSONObject("data").toString();
	}

	Response execute(final WebTarget target) {
		Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
		return invocationBuilder.get();
	}

	private String buildPath(final Entity entity, Map params) {
		String path = entity.path();
		if (params != null) {
			// pop entityId if it exists
			Integer entityId = (Integer) params.remove(entity.entityIdName());
			// construct path differently if entityId included
			if (entityId != null) {
				path += String.format("/%d", entityId);
			}
		}

		return path;
	}

	WebTarget addParams(WebTarget target, final Map params) {
		// default params everyone gets for authentication
		final String ts = String.valueOf(Calendar.getInstance().getTimeInMillis());
		target = target.queryParam("apikey", apiKey).queryParam("ts", ts).queryParam("hash", md5(ts));

		// variable
		if (null != params) {
			for (Map.Entry<String, Object> entry : (Set<Map.Entry<String, Object>>) params.entrySet()) {
				target = target.queryParam(entry.getKey(), entry.getValue());
			}
		}

		return target;
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
