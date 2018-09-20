package ru.stqa.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

/**
 * Abstract class representation of a Page in the UI. Page object pattern
 */
public abstract class PageBase {

    protected WebDriver driver;
    public String PAGE_URL;
    public PageBase(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void goBackBrowserButton() {
        driver.navigate().back();
    }

    public void goForwardBrowserButton() {
        driver.navigate().forward();
    }

    public void reloadPage() {
        driver.navigate().refresh();
    }

    public void type(WebElement locator, String text) {
        locator.click();
        locator.clear();
        locator.sendKeys(text);
    }

    public String getPageUrl() {
        return PAGE_URL;
    }

    public void waitUntilIsLoadedCustomTime(WebElement element, int time) {
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilIsLoaded(WebElement element) {
        try {
            new WebDriverWait(driver, 7).until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadPage() {
        driver.get(getPageUrl());
    }


}
