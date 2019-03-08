package com.qa.youIDraw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Drawing {
	Actions action;

	@FindBy(id = "brush")
	private WebElement brush;

	@FindBy(id = "edSize")
	private WebElement brushSize;

	@FindBy(id = "catch")
	private WebElement canvas;

	public void selectBrush(WebDriver driver) {
		action = new Actions(driver);
		brush.click();
		brushSize.click();
		action.doubleClick().perform();
		action.sendKeys("12").perform();
	}

	public void selectCanvas() {
		action.moveToElement(canvas);
	}

	public void drawPurdyPicture() {
		action.moveByOffset(-400, -200).clickAndHold().moveByOffset(0, 250).release().moveByOffset(0, -125)
				.clickAndHold().moveByOffset(75, -125).release().moveByOffset(-75, 125).clickAndHold()
				.moveByOffset(75, 125).release().perform(); // drawing the K

		action.moveByOffset(20, -250).clickAndHold().moveByOffset(50, 125).moveByOffset(50, -125).release()
				.moveByOffset(-50, 125).clickAndHold().moveByOffset(0, 125).release().perform(); // drawing the Y

		action.moveByOffset(70, 0).clickAndHold().moveByOffset(75, 0).release().moveByOffset(-75, 0).clickAndHold()
				.moveByOffset(0, -250).release().moveByOffset(75, 250).perform(); // drawing the L

		action.moveByOffset(20, -250).clickAndHold().moveByOffset(100, 0).release().moveByOffset(-100, 0).clickAndHold()
				.moveByOffset(0, 125).moveByOffset(100, 0).release().moveByOffset(-100, 0).clickAndHold()
				.moveByOffset(0, 125).moveByOffset(100, 0).release().perform(); // drawing the E

	}
}
