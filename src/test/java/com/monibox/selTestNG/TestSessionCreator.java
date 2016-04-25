package com.monibox.selTestNG;

import com.monibox.selTestNG.keywords.GoogleSearchActions;
import static com.monibox.selTestNG.utils.YamlReader.getYamlValue;
import static com.monibox.selTestNG.utils.YamlReader.getYamlValues;
import static com.monibox.selTestNG.utils.YamlReader.setYamlFilePath;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;

/**
 * The Class TestSessionCreator.
 */
public class TestSessionCreator {

    /**
     * The driver.
     */
    WebDriver driver;

    /**
     * The login actions pg.
     */
    /**
     * The browser.
     */
    String browser;

    /**
     * The seleniumserver.
     */
    String seleniumserver;

    /**
     * The seleniumserverhost.
     */
    String seleniumserverhost;

    /**
     * The appbaseurl.
     */
    String appbaseurl;

    /**
     * The applicationpath.
     */
    String applicationpath;

    /**
     * The chromedriverpath.
     */
    String chromedriverpath;

    public GoogleSearchActions googleSearchAction;

    /**
     * The timeout.
     */
    long timeout;

    /**
     * The chrome options.
     */
    Map<String, Object> chromeOptions = null;

    /**
     * The capabilities.
     */
    DesiredCapabilities capabilities;

    /**
     * Instantiates a new test session initiator.
     *
     * @param datafilelocator the datafilelocator
     */
    public TestSessionCreator(String datafilelocator) {
        setYamlFilePath(datafilelocator);
        _getSessionConfig();
        _configureBrowser();
        _initPage();
    }

    /**
     * _configure browser.
     */
    private void _configureBrowser() {
        Map<String, Object> driverConfig = getYamlValues("selenium");
        driver = WebDriverFactory.getDriver(driverConfig);
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        String gridSessionId = ((RemoteWebDriver) driver).getSessionId().toString();
        System.out.println(" ***Selenium Grid SESSION_ID: "
                + gridSessionId
                + "***\n http://jenkins.mindtap.corp.web:4444/grid/api/testsession?session="
                + gridSessionId);
    }

    /**
     * _get session config.
     */
    private void _getSessionConfig() {
        browser = getYamlValue("selenium.browser");
        seleniumserver = getYamlValue("selenium.server");
        seleniumserverhost = getYamlValue("selenium.remote.host");
        appbaseurl = getYamlValue("baseurl");
        applicationpath = appbaseurl;
        timeout = Integer.parseInt(getYamlValue("selenium.timeout"));
    }

    /**
     * _init page.
     */
    private void _initPage() {
        googleSearchAction = new GoogleSearchActions(driver);
    }

    /**
     * Launch application.
     */
    public void launchApplication() {
        System.out.println("The application url is :- " + applicationpath);
        driver.get(applicationpath);
    }

    /**
     * Launch url.
     *
     * @param URL the url
     */
    public void launchUrl(String URL) {
        driver.get(URL);
    }

    /**
     * Launch application url.
     *
     * @param URL the url
     */
    public void launchApplicationUrl(String URL) {
        launchUrl(URL);
    }

    /**
     * Close browser session.
     */
    public void closeBrowserSession() {
        driver.quit();
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    /**
     * Take screenshot of failure.
     *
     * @param result the result
     */
    public void takeScreenshotOfFailure(ITestResult result) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
        String methodName = result.getName();
        WebDriver augmentedDriver = new Augmenter().augment(driver);
        if (!result.isSuccess()) {
            try {
                File scrFile = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(scrFile, new File("target/failsafe-reports/screenshots/"
                        + methodName + "_" + formater.format(calendar.getTime()) + ".jpg"));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public void takeScreenshotOfFailureFromLocalMachine(ITestResult result) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
        String methodName = result.getName();
        if (!result.isSuccess()) {
            try {
                File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(scrFile, new File("target/failsafe-reports/screenshots/"
                        + methodName + "_" + formater.format(calendar.getTime()) + ".jpg"));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
