/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monibox.selTestNG.smoke.tests;

import static com.monibox.selTestNG.utils.YamlReader.getYamlValue;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.monibox.selTestNG.TestSessionCreator;

/**
 *
 * @author qainfotech
 */
public class googleSmokeTest {

    TestSessionCreator test;

    String courseKey;

    String environment;

    String product, url;

    @BeforeClass
    public void setUpClass() {
        System.out.println("_______________________________________________________________________");
        System.out.println("xxxxxxxxxxxxxxxxx search Engine Smoke Test xxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println("-----------------------------------------------------------------------");
        test = new TestSessionCreator(System.getProperty("datafile", "testDataFile.yml"));
        environment = System.getProperty("environment", getYamlValue("testenv"));
        product = System.getProperty("product", "google");
        url = getYamlValue("baseurl");

        System.out.println("Course::" + url);
    }

    @BeforeMethod
    public void init() {
        System.out.println("__________________________________________________________________________");
    }
    
    @Test
    public void launchPage(){
        test.launchUrl(url);
        test.googleSearchAction.verifyPageTitle();
    }

    @AfterMethod
    public void captureScreenShotOnFailure(ITestResult result) {
        System.out.println("******************************************************");
        System.out.println("Test Name: " + result.getName());
        if (!result.isSuccess()) {
            System.out.println("Test Result: FAIL");
            if (getYamlValue("selenium.server").equalsIgnoreCase("remote")) {
                test.takeScreenshotOfFailure(result);
            } else {
                test.takeScreenshotOfFailureFromLocalMachine(result);
            }
        } else {
            System.out.println("Test Result: PASS");
        }
        System.out.println("******************************************************");
        System.out.println("__________________________________________________________________________");
    }

    /**
     * Tear down class.
     *
     * @throws Exception the exception
     */
    @AfterClass
    public void tearDownClass() throws Exception {
        test.closeBrowserSession();
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

    }
}
