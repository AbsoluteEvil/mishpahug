package ru.stqa.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class ProfilePage extends PageBase {

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement firstNameField;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastNameField;

    @FindBy(xpath = "//input[@placeholder='Phone Number']")
    WebElement phoneNumberField;

    @FindBy(xpath = "//mat-select[@placeholder='Confession']")
    WebElement confessionField;

    @FindBy(xpath = "//span[@class='mat-option-text']")
    WebElement dropDownMenuList;

    @FindBy(xpath = "//button[@aria-label='Open calendar']")
    WebElement openCalendarButton;

    @FindBy(xpath = "//div[@class='mat-calendar-arrow']")
    WebElement selectYearButton;

    @FindBy(xpath = "//button[@aria-label='Open calendar']")
    WebElement openYearSelectionMenu;

    @FindBy(xpath = "//button[@aria-label='Previous 20 years']")
    WebElement previous20Years;

    @FindBy(xpath = "//button[@aria-label='Previous month']")
    WebElement previousMonth;

    @FindBy(xpath = "//tbody[@class='mat-calendar-body']")
    WebElement calendarTable;

    @FindBy(xpath = "//mat-select[@placeholder='Food Preferences']")
    WebElement foodPreferencesField;

    @FindBy(xpath = "//mat-select[@placeholder='Languages']")
    WebElement languagesField;

    @FindBy(xpath = "//mat-select[@placeholder='Marital Status']")
    WebElement maritalStatus;

    @FindBy(xpath = "//div[@class='d-flex flex-row justify-content-center']//button[2]")
    WebElement editProfileButton;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitButton;


    public ProfilePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement selectNumber(int text) {
        return driver.findElement(By.xpath((calendarTable.toString()) + "//div[contains(text()," + text + "')]"));
    }

    public WebElement selectMonth(String text) {
        return driver.findElement(By.xpath((calendarTable.toString()) + "//div[contains(text()," + text + "')]"));
    }

    public ProfilePage clickEditButton(){
        editProfileButton.click();
        return this;
    }

    public ProfilePage selectBirthdayInCalendar(Calendar date) throws InterruptedException {
        openCalendarButton.click();
        selectYearButton.click();
        while (!selectNumber(date.get(Calendar.YEAR)).isDisplayed()) {
            previous20Years.click();
        }
        selectNumber(date.get(Calendar.YEAR)).click();
        String month = new SimpleDateFormat("MMM", Locale.ENGLISH).format(date.getTime());
        selectMonth(month.toUpperCase());
        selectNumber(date.get(Calendar.DATE));
        return this;
    }

    private void pressEsc() {
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ESCAPE).build().perform();
    }

    private void selectAllCheckboxes() {
        foodPreferencesField.click();
        List<WebElement> els = driver.findElements(By.xpath("//mat-pseudo-checkbox"));
        for (
                WebElement el : els)

        {
            if (!el.isSelected()) {
                el.click();
            }
        }
        pressEsc();
    }
}
