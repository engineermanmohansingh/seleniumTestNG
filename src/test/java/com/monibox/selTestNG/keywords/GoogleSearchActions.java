/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monibox.selTestNG.keywords;

import com.monibox.selTestNG.pageuiobjects.googlePageUI;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author qainfotech
 */
public class GoogleSearchActions {

    googlePageUI googleUI;
    WebDriver driver;

    public GoogleSearchActions(WebDriver driver) {
        googleUI = new googlePageUI(driver);
        this.driver = driver;
    }

    public boolean verifyPageTitle() {
        String title = googleUI.getPageTitle();
        System.out.print(title);
        if (title.contains("Google")) {
            return true;
        } else {
            return false;
        }
    }
}
