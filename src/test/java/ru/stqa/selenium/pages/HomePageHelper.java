package ru.stqa.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import ru.stqa.selenium.LoginTest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/**
 * Sample page
 */
public class HomePageHelper extends PageBase {

    @FindBy(xpath = "//span[@class='ng-star-inserted']")
    WebElement menuButton;

    @FindBy(xpath = "//span[contains(text(),'Profile')]")
    WebElement profilePage;


    public HomePageHelper(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(driver, this);
    }

    public HomePageHelper pressMenuButton() {
        menuButton.click();
        return this;
    }

    public HomePageHelper goToProfilePage() {
        profilePage.click();
        return this;
    }

}

