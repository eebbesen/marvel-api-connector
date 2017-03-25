package com.humegatech.marvelapi.automation.functional;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.humegatech.marvelapi.MarvelAPIConnector;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

public class GreetTestCases extends
		AbstractTestCase<MarvelAPIConnector> {

	public GreetTestCases() {
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
		java.lang.String friend = null;
		assertEquals(getConnector().greet(friend), expected);
	}

}