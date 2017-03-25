package com.humegatech.marvelapi.automation.functional;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.humegatech.marvelapi.MarvelAPIConnector;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

public class AddEntityTestCases extends
		AbstractTestCase<MarvelAPIConnector> {

	public AddEntityTestCases() {
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
    public void verify() throws Exception {
    	java.util.Map<java.lang.String, java.lang.Object> expected = null;
		java.lang.String key = null;
		java.util.Map<java.lang.String, java.lang.Object> entity = null;
		assertEquals(getConnector().addEntity(key, entity), expected);
    }
    
}