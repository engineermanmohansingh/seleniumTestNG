/*
 * 
 */
package com.monibox.selTestNG.utils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * The Class SeleniumWait.
 */
public class SeleniumWait {

	/** The driver. */
	WebDriver driver;

	/**
	 * Instantiates a new selenium wait.
	 * 
	 * @param driver
	 *            the driver
	 */
	public SeleniumWait(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Gets the when visible.
	 * 
	 * @param locator
	 *            the locator
	 * @param timeout
	 *            the timeout
	 * @return the when visible
	 */
	public WebElement getWhenVisible(By locator, int timeout) {
		WebElement element;
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return element;
	}

	public List<WebElement> getWhenVisibleList(By locator, int timeout) {
		List<WebElement> element;
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		element = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		return element;
	}
        
        public List<WebElement> getList(By locator) {
                return driver.findElements(locator);
	}

	/**
	 * Gets the when clickable.
	 * 
	 * @param locator
	 *            the locator
	 * @param timeout
	 *            the timeout
	 * @return the when clickable
	 */
	public WebElement getWhenClickable(By locator, int timeout) {
		WebElement element;
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		return element;
	}

	/**
	 * Click when ready.
	 * 
	 * @param locator
	 *            the locator
	 * @param timeout
	 *            the timeout
	 */
	public void clickWhenReady(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
	}

	/**
	 * Wait for dom to load.
	 */
	public void waitForDomToLoad() {
		WebDriverWait wait = new WebDriverWait(driver, 80);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*")));
	}

	public void waitForElementToDisappear(By locator, int timeOut) {
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
		driver.manage()
						.timeouts()
						.implicitlyWait(Integer.parseInt(YamlReader
										.getYamlValue("selenium.timeout")), TimeUnit.SECONDS);
	}

	public WebElement getWhenVisibleWithOutImplicit(By locator, int timeout) {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement element;
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		driver.manage()
						.timeouts()
						.implicitlyWait(Integer.parseInt(YamlReader
										.getYamlValue("selenium.timeout")), TimeUnit.SECONDS);
		return element;
	}
}
