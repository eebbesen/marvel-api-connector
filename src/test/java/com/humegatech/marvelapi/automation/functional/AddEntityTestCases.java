package com.humegatech.marvelapi.automation.functional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

import com.humegatech.marvelapi.MarvelAPIConnector;

public class AddEntityTestCases extends AbstractTestCase<MarvelAPIConnector> {

	public AddEntityTestCases() {
		super(MarvelAPIConnector.class);
	}

	@Before
	public void setup() {
	}

	@After
	public void tearDown() {
	}

	@Test
	public void verify() throws Exception {
		java.util.Map<java.lang.String, java.lang.Object> expected = null;
		java.lang.String key = null;
		java.util.Map<java.lang.String, java.lang.Object> entity = null;
		// assertEquals(getConnector().addEntity(key, entity), expected);
	}

}