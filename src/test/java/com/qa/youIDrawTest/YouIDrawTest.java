package com.qa.youIDrawTest;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.youIDraw.Drawing;

public class YouIDrawTest {
WebDriver driver;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver",  "C:/Users/Admin/Desktop/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.youidraw.com/apps/painter/#");
		
	}
	
	@After
	public void teardown() throws InterruptedException {
		Thread.sleep(4000);
		driver.quit();
	}
	
	@Test
	public void drawing() throws InterruptedException, IOException {
		
		Drawing draw = PageFactory.initElements(driver, Drawing.class);
		draw.selectBrush(driver);
		draw.selectCanvas();
		draw.drawPurdyPicture();
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		System.out.println(scrFile.getAbsolutePath());
		Desktop desktop = Desktop.getDesktop();
		if(scrFile.exists()) desktop.open(scrFile);
	}
}
