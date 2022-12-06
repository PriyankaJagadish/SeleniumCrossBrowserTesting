package com.infy.selenium.crossbrowsertesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBrowserFrameworkTest {
	@Parameters("browser")
	@Test
	public void chromeBrowser(@Optional("chrome") String browser) {
		WebDriver driver = null;
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			throw new RuntimeException("Does not Support" + browser);
		}
		driver.get("https://magento.softwaretestingboard.com");
		driver.quit();
	}
}
