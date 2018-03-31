package com.automation.DemoProject;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoPageClass {

	static WebDriver driver;

	public static void setProperty(String url) {
		System.out.println("Hello World!");

		System.setProperty("webdriver.chrome.driver", "C:/Automation/chromedriver_win32/chromedriver.exe");

		driver = new ChromeDriver();
		// driver = new FirefoxDriver();
		driver.navigate().to(url);
		driver.manage().window().maximize();
	}

	public static void waitForHomePage() {
		WebElement home = driver.findElement(By.linkText("Home1"));
		WebElement tools = driver.findElement(By.linkText("Testing"));
	}

	public static void clickOnTesting() {
		WebElement element = driver.findElement(By.linkText("Learn Software Testing"));
		element.click();
	}

	public static void waitForTestingPage() {
		driver.findElement(By.linkText("Home")).isDisplayed();
		driver.findElement(By.partialLinkText("Testing"));
		driver.quit();
	}

	public static void captureScreenshot() {
		// Take screenshot and store as a file format
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			// now copy the screenshot to desired location using copyFile method

			FileUtils.copyFile(src, new File("C:/selenium1/" + System.currentTimeMillis() + ".png"));
		}

		catch (IOException e)

		{

			System.out.println(e.getMessage());

		}

		

	}

}
