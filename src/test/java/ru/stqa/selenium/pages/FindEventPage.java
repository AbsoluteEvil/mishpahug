package ru.stqa.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FindEventPage extends PageBase {

    @FindBy(xpath="//button[@class='mat-raised-button']")
    WebElement filterButton;

    @FindAll( {@FindBy(xpath = "//div//button[@type='button']")})
    private List<WebElement> openCalendarButtons;

    public FindEventPage(WebDriver driver) {
        super(driver);
    }

    public FindEventPage clickDateFromButton() {
        openCalendarButtons.get(0).click();
        return this;
    }

    public FindEventPage clickDateToButton() {
        openCalendarButtons.get(1).click();
        return this;
    }



}
