package ru.stqa.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Sample page
 */
public class HomePage extends PageBase {

    @FindBy(xpath = "//h1[@class='gorisontal-center']")
    WebElement header;

    @FindBy(xpath = "//span/*[@mattooltip='Menu']")
    WebElement menuButton;

    @FindBy(xpath = "//span[contains(text(),'Profile')]")
    WebElement profilePage;

    @FindBy(xpath = "//div[@class='mainContainer']")
    WebElement menu;

    @FindBy(xpath = "//span[contains(text(),'Login')]")
    WebElement loginButton;

    @FindBy(xpath = "//span[contains(text(),'Create Account')]")
    WebElement registrationButton;

    @FindAll( {@FindBy(xpath = "//div[@class='insideDiv']//button/span")})
    private List<WebElement> elementsOfMainMenu;

    @FindBy(xpath = "//span[contains(text(),'Create Account')]")
    WebElement eventsPage;


    public HomePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(driver, this);
    }

    public HomePage pressMenuButton() {
        menuButton.click();
        return this;
    }
    public HomePage goToEventsPage() {
        elementsOfMainMenu.get(0).click();
        return this;
    }

    public HomePage goToNoticePage() {
        elementsOfMainMenu.get(1).click();
        return this;
    }

    public HomePage goToCalendarPage() {
        elementsOfMainMenu.get(2).click();
        return this;
    }

    public HomePage goToParticipationPage() {
        elementsOfMainMenu.get(3).click();
        return this;
    }

    public HomePage goToMyeventsPage() {
        elementsOfMainMenu.get(4).click();
        return this;
    }

    public HomePage goToProfilePage() {
        elementsOfMainMenu.get(5).click();
        return this;
    }

    public HomePage logOut() {
        elementsOfMainMenu.get(6).click();
        return this;
    }

    public HomePage clickButtonRegistration() {
        registrationButton.click();
        return this;
    }

    public HomePage clickButtonLogin() {
        loginButton.click();
        return this;
    }

    public void waitUntilMenuLoaded() {
        this.waitUntilIsLoadedCustomTime(header,40);
    }
}

