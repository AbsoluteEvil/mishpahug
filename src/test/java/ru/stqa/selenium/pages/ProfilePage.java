package ru.stqa.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

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
    WebElement yearSelectionMenu;

    @FindBy(xpath = "//button[@aria-label='Open calendar']")
    WebElement openYearSelectionMenu;

    @FindBy(xpath = "//button[@aria-label='Previous 20 years']")
    WebElement previous20Years;

    @FindBy(xpath = "//button[@aria-label='Next 20 years']")
    WebElement next20Years;

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

    @FindAll({
            @FindBy(xpath = "//tbody[@class='mat-calendar-body']/tr/td/div")})
    private List<WebElement> whatTableContains;


    public ProfilePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement selectDate(int text) {
        return driver.findElement(By.xpath("//tbody[@class='mat-calendar-body']//div[contains(text(),'" + text + "')]"));
    }

    private List<WebElement> getElements(Calendar date) {
        return driver.findElements(By.xpath("//tbody[@class='mat-calendar-body']//div[contains(text(),'" + date.get(Calendar.YEAR) + "')]"));
    }

    public WebElement selectMonth(Calendar date) {
        String sdf = new SimpleDateFormat("MMM", Locale.ENGLISH).format(date.getTime());
        WebElement month = driver.findElement(By.xpath("//tbody[@class='mat-calendar-body']//div[contains(text(),'" + sdf.toUpperCase() + "')]"));
        return month;
    }

    public ProfilePage clickEditButton() {
        editProfileButton.click();
        return this;
    }

    public ProfilePage selectYear(int year) {
        int firstYear = Integer.parseInt(whatTableContains.get(0).getText());
        int lastYear = Integer.parseInt(whatTableContains.get(whatTableContains.size() - 1).getText());
        while (year < firstYear) {
            previous20Years.click();
            firstYear = Integer.parseInt(whatTableContains.get(0).getText());
        }
        while (year > lastYear) {
            next20Years.click();
            lastYear = Integer.parseInt(whatTableContains.get(whatTableContains.size() - 1).getText());
        }
        selectDate(year).click();
        return this;
    }

    public ProfilePage selectBirthdayInCalendar(Calendar date) throws InterruptedException {
        System.out.println(date.get(Calendar.DATE)+"."+date.get(Calendar.MONTH)+"."+date.get(Calendar.YEAR));
        openCalendarButton.click();
        yearSelectionMenu.click();
        selectYear(date.get(Calendar.YEAR));
        selectMonth(date).click();
        selectDate(date.get(Calendar.DATE)).click();
        return this;
    }


    private void pressEsc() {
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ESCAPE).build().perform();
    }

    private void selectAllCheckboxes() {
        foodPreferencesField.click();
        List<WebElement> els = driver.findElements(By.xpath("//mat-pseudo-checkbox"));
        for (WebElement el : els) {
            if (!el.isSelected()) {
                el.click();
            }
        }
        pressEsc();
    }

    public void waitUntilPageLoaded() {
        this.waitUntilIsLoadedCustomTime(firstNameField,40);
    }
}
