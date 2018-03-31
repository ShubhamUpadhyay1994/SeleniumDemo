package com.automation.DemoProject;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class DemoTestClass {

	@Test(alwaysRun = true)
	@Parameters({"url"})
	public static void testUrl(String url) {
		DemoPageClass.setProperty(url);
	}

	@Test(dependsOnMethods="testUrl")
	public void testHomePage() {
		DemoPageClass.waitForHomePage();
		DemoPageClass.clickOnTesting();
		DemoPageClass.waitForTestingPage();
	}

}
