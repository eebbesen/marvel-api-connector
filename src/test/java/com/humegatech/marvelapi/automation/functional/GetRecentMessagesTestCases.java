package com.humegatech.marvelapi.automation.functional;

import static org.junit.Assert.*;
import java.util.Collection;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.humegatech.marvelapi.MarvelAPIConnector;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

public class GetRecentMessagesTestCases extends 
		AbstractTestCase<MarvelAPIConnector> {

	public GetRecentMessagesTestCases() {
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
	public void verify() throws Throwable {
		Object[] args = new Object[] { null }; // TODO initialize parameters
		int expectedSize = 0;
		Collection<?> result = (Collection<?>) getDispatcher()
				.runPaginatedMethod("getRecentMessages", args);
		assertEquals(expectedSize, result.size());
	}
	
}