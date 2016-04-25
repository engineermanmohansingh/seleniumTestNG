package com.monibox.selTestNG.pageuiobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.monibox.selTestNG.utils.SeleniumWait;

/**
 * The Class BasePage.
 */
public class BasePage extends SeleniumWait {

    protected WebDriver driver;

    protected SeleniumWait expWait;

    /**
     * Instantiates a new base page.
     *
     * @param driver the driver
     */
    public BasePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
        expWait = new SeleniumWait(driver);
    }

    /**
     * Gets the page title.
     *
     * @return the page title
     */
    public String getPageTitle() {
        return driver.getTitle();
    }

    /**
     * Gets the element by index.
     *
     * @param elementlist the elementlist
     * @param index the index
     * @return the element by index
     */
    protected WebElement getElementByIndex(List<WebElement> elementlist, int index) {
        return elementlist.get(index);
    }

    /**
     * Gets the element by text.
     *
     * @param elementlist the elementlist
     * @param elementtext the elementtext
     * @return the element by text
     */
    protected WebElement getElementByText(List<WebElement> elementlist, String elementtext) {
        WebElement element = null;
        for (WebElement elem : elementlist) {
            if (elem.getText().equalsIgnoreCase(elementtext)) {
                element = elem;
            }
        }
        if (element == null) {
        }
        return element;
    }

    /**
     * Gets the window handle.
     *
     * @return the window handle
     */
    public void getWindowHandle() {
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
    }

    /**
     * Gets the token name.
     *
     * @param token the token
     * @return the token name
     */
    public void get_TokenName(String token) {
        waitLong(token.length());
    }

    /**
     * Switch to frame.
     *
     * @param stf the stf
     */
    public void switchToFrame(String stf) {
        WebDriverWait wait = new WebDriverWait(driver, 120);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(stf));
    }

    public void switchToFrameWithRender(String stf) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(stf));
    }

    public void switchToFrame(WebElement element) {
        driver.switchTo().frame(element);
        logMessage("Driver switched to the frame");
    }

    public void logMessage(String message) {
        Reporter.log(message, true);
    }

    /**
     * Switch to default content.
     */
    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    /**
     * Click on log out.
     */
    public void clickOnLogOut() {
        driver.findElement(By.xpath(".//*[@class[contains(.,'user-menu-link')]]")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('logout_link').click();");
    }

    /**
     * Wait for sync page.
     */
    public void waitForSyncPage() {
        expWait.waitForDomToLoad();
    }

    /**
     * Wait long.
     *
     * @param i the i
     */
    public void waitLong(int i) {
        try {
            Thread.sleep(i * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Check week slider spinner to disappear.
     */
    public void checkWeekSliderSpinnerToDisappear() {
        //expWait.waitForElementToDisappear(By.id("weekslider"), 5);
        waitLong(5);
    }

    /**
     * Check week slider spinner to appear.
     */
    public void checkWeekSliderSpinnerToAppear() {
        //expWait.waitForElementToDisappear(By.id("weekslider"), 2);
        waitLong(5);
    }

    /**
     * Execute javascript.
     *
     * @param script the script
     */
    public void executeJs(String script) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script, (Object) null);
    }

    /**
     * Select element from dropdown.
     *
     * @param selectElement the select element
     * @param selectorType the selector type
     * @param sel the sel
     */
    public void SelectElementFromDropdown(WebElement selectElement, String selectorType, String sel) {
        Select select = new Select(selectElement);
        if (selectorType.equalsIgnoreCase("index")) {
            select.selectByIndex(Integer.parseInt(sel));
        }
        if (selectorType.equalsIgnoreCase("visibleText")) {
            select.selectByVisibleText(sel);
        }
        if (selectorType.equalsIgnoreCase("value")) {
            select.selectByValue(sel);
        }
    }

    public void reportLog(String message) {
        System.out.println(message);
        Reporter.log(message);
    }

    public void scrollDown(WebElement element) {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView(true);", element);
    }
}
