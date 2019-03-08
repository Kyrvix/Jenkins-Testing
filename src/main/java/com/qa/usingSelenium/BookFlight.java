package com.qa.usingSelenium;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookFlight {

	WebDriver driver;
	
	public BookFlight(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[3]/td[2]/b/select")
	private WebElement passengers;
	
	@FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[4]/td[2]/select")
	private WebElement departFrom;
	
	@FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[6]/td[2]/select")
	private WebElement arriveAt;
	
	@FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[7]/td[2]/select[1]")
	private WebElement returning;
	
	@FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[9]/td[1]/font/b")
	private WebElement serviceClass;
	
	@FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[10]/td[2]/select")
	private WebElement airline;
	
	@FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[14]/td/input")
	private WebElement cont;
	
	@FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr[2]/td[1]/font")
	private WebElement select;
	
	@FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/p/input")
	private WebElement cheapFlight;
	
	@FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[24]/td/input")
	private WebElement securePurchase;
	
	@FindBy(xpath ="/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td/table/tbody/tr[1]/td")
	private WebElement allBooked;
	
	public boolean fillOutForm() throws InterruptedException {
		Actions action = new Actions(driver);

		action.click(passengers).perform();
		action.sendKeys(Keys.ARROW_DOWN).perform();
//		Thread.sleep(1000);
		
//		Thread.sleep(5000);
		
		departFrom.click();
		action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();
		departFrom.click();
		
		arriveAt.click();
		for(int i = 0; i < 4; i++) {
			action.sendKeys(Keys.ARROW_DOWN).perform();
		}
		arriveAt.click();
		
		returning.click();
		action.sendKeys(Keys.ARROW_DOWN).perform();
		returning.click();
		
		action.click(serviceClass).sendKeys(Keys.TAB).sendKeys(Keys.ARROW_UP).perform();
		
		airline.click();
		action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();
		airline.click();
		
		cont.click();
		
		action.click(select).sendKeys(Keys.TAB).sendKeys(Keys.ARROW_UP).sendKeys(Keys.TAB).sendKeys(Keys.ARROW_UP).perform();
		cheapFlight.click();
		
		securePurchase.click();
		
		return allBooked.isDisplayed();
	}
	
}
