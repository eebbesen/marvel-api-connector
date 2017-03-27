package com.humegatech.marvelapi.config;

import java.util.Map;

import org.mule.api.annotations.Configurable;
import org.mule.api.annotations.components.Configuration;

import com.humegatech.marvelapi.client.MarvelAPIClient;
import com.humegatech.marvelapi.client.MarvelAPIClientInterface;

@Configuration(friendlyName = "Configuration")
public class ConnectorConfig {
	private MarvelAPIClientInterface client;
	private Map params;

	/**
	 * Your Marvel Comics API public key
	 */
	@Configurable
	private String publicKey;

	/**
	 * Your Marvel Comics API private key
	 */
	@Configurable
	private String privateKey;

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

	public String getPublicKey() {
		return publicKey;
	}

	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}

	public String getPrivateKey() {
		return privateKey;
	}

	public void setParams(Map params) {
		this.params = params;
	}

	public String getComics() {
		return getClient().getComics(params);
	}

	public String getCharacters() {
		return getClient().getCharacters(params);
	}

	public String getCreators() {
		return getClient().getCreators(params);
	}

	public String getEvents() {
		return getClient().getEvents(params);
	}

	public String getSeries() {
		return getClient().getSeries(params);
	}

	public String getStories() {
		return getClient().getStories(params);
	}

	private MarvelAPIClientInterface getClient() {
		if (client == null) {
			client = new MarvelAPIClient(publicKey, privateKey);
		}

		return client;
	}

}