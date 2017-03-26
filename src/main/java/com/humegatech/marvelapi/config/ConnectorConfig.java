package com.humegatech.marvelapi.config;

import java.util.Map;

import org.mule.api.annotations.Configurable;
import org.mule.api.annotations.components.Configuration;
import org.mule.api.annotations.param.Default;

import com.humegatech.marvelapi.client.MarvelAPIClient;
import com.humegatech.marvelapi.client.MarvelAPIClientInterface;

@Configuration(friendlyName = "Configuration")
public class ConnectorConfig {
	private MarvelAPIClientInterface client;
	private Map params;

	/**
	 * Marvel Comics API public key
	 */
	@Configurable
	@Default("Hello")
	private String publicKey;

	/**
	 * Marvel Comics API private key
	 */
	@Configurable
	@Default("How are you?")
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
		return getClient().getComics();
	}

	public String getComics(Map params) {
		return getClient().getComics(params);
	}

	public String getCharacters() {
		return getClient().getCharacters();
	}

	public String getCharacters(Map params) {
		return getClient().getCharacters(params);
	}

	private MarvelAPIClientInterface getClient() {
		if (client == null) {
			client = new MarvelAPIClient(publicKey, privateKey);
		}

		return client;
	}

}