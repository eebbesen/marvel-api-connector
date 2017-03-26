package com.humegatech.marvelapi.automation.functional;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

import com.humegatech.marvelapi.MarvelAPIConnector;

public class GetComicsTestCases extends AbstractTestCase<MarvelAPIConnector> {

	public GetComicsTestCases() {
		super(MarvelAPIConnector.class);
	}

	@Before
	public void setup() {
		// TODO
	}

	@After
	public void tearDown() {
		// TODO
	}

	@Test
	public void verify() {
		java.lang.String expected = null;
		assertEquals(getConnector().getComics(), expected);
	}

}