package com.humegatech.marvelapi.automation.runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import com.humegatech.marvelapi.automation.functional.AddEntityTestCases;
import com.humegatech.marvelapi.automation.functional.GetRecentMessagesTestCases;
import com.humegatech.marvelapi.automation.functional.GreetTestCases;
import com.humegatech.marvelapi.automation.functional.QueryProcessorTestCases;
import com.humegatech.marvelapi.MarvelAPIConnector;
import org.mule.tools.devkit.ctf.mockup.ConnectorTestContext;

@RunWith(Suite.class)
@SuiteClasses({
	AddEntityTestCases.class,
	GetRecentMessagesTestCases.class,

GreetTestCases.class
	,QueryProcessorTestCases.class
})

public class FunctionalTestSuite {
	
	@BeforeClass
	public static void initialiseSuite(){
		ConnectorTestContext.initialize(MarvelAPIConnector.class);
	}
	
	@AfterClass
    public static void shutdownSuite() {
    	ConnectorTestContext.shutDown();
    }
	
}