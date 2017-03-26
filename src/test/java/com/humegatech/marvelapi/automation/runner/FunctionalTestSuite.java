package com.humegatech.marvelapi.automation.runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.mule.tools.devkit.ctf.mockup.ConnectorTestContext;

import com.humegatech.marvelapi.MarvelAPIConnector;
import com.humegatech.marvelapi.automation.functional.AddEntityTestCases;
import com.humegatech.marvelapi.automation.functional.GetComicsTestCases;
import com.humegatech.marvelapi.automation.functional.GetRecentMessagesTestCases;
import com.humegatech.marvelapi.automation.functional.QueryProcessorTestCases;

@RunWith(Suite.class)
@SuiteClasses({ AddEntityTestCases.class, GetRecentMessagesTestCases.class,

		GetComicsTestCases.class, QueryProcessorTestCases.class })

public class FunctionalTestSuite {

	@BeforeClass
	public static void initialiseSuite() {
		ConnectorTestContext.initialize(MarvelAPIConnector.class);
	}

	@AfterClass
	public static void shutdownSuite() {
		ConnectorTestContext.shutDown();
	}

}