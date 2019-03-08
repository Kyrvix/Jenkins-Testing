package com.qa.usingSelenium;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class SeleniumTesting {
	ChromeDriver driver;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver",  Constant.chromeLoc);
		driver = new ChromeDriver();
		driver.get(Constant.siteURL);
	}
	
	@After
	public void teardown() {
		driver.quit();
	}
	
	@Test
	public void methodTest() throws InterruptedException {
		Homepage homepage = PageFactory.initElements(driver, Homepage.class);
		homepage.goRegister();
		
		Register register = PageFactory.initElements(driver, Register.class);
		register.goRegister(Constant.theUser, Constant.thePass);
		
		register.isRegistered();
		
		SignIn signIn = PageFactory.initElements(driver, SignIn.class);
		signIn.login(Constant.theUser, Constant.thePass);
		
		BookFlight bookFlight = new BookFlight(driver);
		bookFlight.fillOutForm();
		Thread.sleep(2000);
		assertEquals("Flight not booked", true, bookFlight.fillOutForm());
	}
}
