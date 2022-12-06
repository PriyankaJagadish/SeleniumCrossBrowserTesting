package com.infy.selenium.crossbrowsertesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBrowserFrameworkWithBeforeAfterTest {

	WebDriver driver = null;

	@Parameters("browser")
	@BeforeTest
	public void beforeTest(@Optional("chrome") String browser) {
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			throw new RuntimeException("Does not Support" + browser);
		}
	}

	@Test
	public void launchPage() {
		driver.get("https://Google.com");

	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
