package com.humegatech.marvelapi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mule.api.annotations.Config;
import org.mule.api.annotations.Connector;
import org.mule.api.annotations.MetaDataScope;
import org.mule.api.annotations.Paged;
import org.mule.api.annotations.Processor;
import org.mule.api.annotations.Query;
import org.mule.api.annotations.Source;
import org.mule.api.annotations.SourceStrategy;
import org.mule.api.annotations.lifecycle.OnException;
import org.mule.api.annotations.param.Default;
import org.mule.api.annotations.param.MetaDataKeyParam;
import org.mule.api.callback.SourceCallback;
import org.mule.streaming.PagingConfiguration;
import org.mule.streaming.ProviderAwarePagingDelegate;

import com.humegatech.marvelapi.config.ConnectorConfig;
import com.humegatech.marvelapi.error.ErrorHandler;

@Connector(name = "marvel-api", friendlyName = "Marvel API")
@MetaDataScope(DataSenseResolver.class)
@OnException(handler = ErrorHandler.class)
public class MarvelAPIConnector {

	@Config
	ConnectorConfig config;

	/**
	 * Get Marvel character data
	 *
	 * @return JSON representation of characters
	 */
	@Processor
	public String getCharacters() {
		return config.getCharacters();
	}

	/**
	 * Get Marvel comic data
	 *
	 * @return JSON representation of comics
	 */
	@Processor
	public String getComics() {
		return config.getComics();
	}

	/**
	 * Get Marvel comic creator data
	 *
	 * @return JSON representation of comic creators
	 */
	@Processor
	public String getCreators() {
		return config.getCreators();
	}

	/**
	 * Get Marvel Universe event data
	 *
	 * @return JSON representation of events in the Marvel Universe
	 */
	@Processor
	public String getEvents() {
		return config.getEvents();
	}

	/**
	 * Get Marvel series data
	 *
	 * @return JSON representation of series
	 */
	@Processor
	public String getSeries() {
		return config.getSeries();
	}

	/**
	 * Get Marvel story data
	 *
	 * @return JSON representation of stories
	 */
	@Processor
	public String getStories() {
		return config.getStories();
	}

	/**
	 * Description for query
	 *
	 * @param query
	 *            The dsql query
	 * @return List of elements that match the criteria
	 */
	@Processor
	public List<Object> queryProcessor(@Query String query) {
		// TODO
		/*
		 * MESSAGE PROCESSOR CODE GOES HERE
		 */
		return new ArrayList<Object>();
	}

	/**
	 * DataSense processor
	 * 
	 * @param key
	 *            Key to be used to populate the entity
	 * @param entity
	 *            Map that represents the entity
	 * @return Some string
	 */
	@Processor
	public Map<String, Object> addEntity(@MetaDataKeyParam String key,
			@Default("#[payload]") Map<String, Object> entity) {
		/*
		 * USE THE KEY AND THE MAP TO DO SOMETHING
		 */
		return entity;
	}

	/**
	 * Custom Message Source
	 *
	 * @param callback
	 *            The sourcecallback used to dispatch message to the flow
	 * @throws Exception
	 *             error produced while processing the payload
	 */
	@Source(sourceStrategy = SourceStrategy.POLLING, pollingPeriod = 5000)
	public void getNewMessages(SourceCallback callback) throws Exception {
		/*
		 * Every 5 the flow using this processor will be called and the payload
		 * will be the one defined here.
		 * 
		 * The PAYLOAD can be anything. In this example a String is used.
		 */
		callback.process("Start working");
	}

	/**
	 * Get Paginated Result
	 *
	 * @param pagingConfiguration
	 *            Page size.
	 * @throws Exception
	 *             error produced while processing the request
	 */
	@Paged
	@Processor
	public ProviderAwarePagingDelegate<Object, MarvelAPIConnector> getRecentMessages(
			PagingConfiguration pagingConfiguration) throws Exception {
		// TODO The pagination logic can be defined in this custom class, or
		// simple create an annonimous class here.
		return new PagesProvider(pagingConfiguration);
	}

	public ConnectorConfig getConfig() {
		return config;
	}

	public void setConfig(ConnectorConfig config) {
		this.config = config;
	}

}
