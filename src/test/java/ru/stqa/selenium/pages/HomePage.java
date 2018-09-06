package ru.stqa.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Sample page
 */
public class HomePage extends PageBase {

    @FindBy(xpath = "//span[@class='ng-star-inserted']")
    WebElement menuButton;

    @FindBy(xpath = "//span[contains(text(),'Profile')]")
    WebElement profilePage;

    @FindBy(xpath = "//div[@class='mainContainer']")
    WebElement menu;


    public HomePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(driver, this);
    }

    public HomePage pressMenuButton() {
        menuButton.click();
        return this;
    }

    public HomePage goToProfilePage() {
        profilePage.click();
        return this;
    }
    public HomePage waitUntilMenuLoaded() {
        this.waitUntilIsLoadedCustomTime(menu,40);
        return this;
    }

    public HomePage waitUntilPageLoad() {
        this.menu.isDisplayed();
        return this;
    }

}

