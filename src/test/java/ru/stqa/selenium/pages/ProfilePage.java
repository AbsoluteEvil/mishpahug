package ru.stqa.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.stqa.selenium.TestBase;

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


    public void selectText(String text) {
        driver.findElements(By.xpath("//div[contains(text()," + text + "')]"));
        driver.findElement(calendarTable)
    }

    public ProfilePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    public void fillUserInformation(String firstname, String lastname, String phone, String confession, Calendar date, String text) throws InterruptedException {
        click(By.xpath("//span[contains(text(),'Change')]"));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(6000);
        //birthDate
        selectBirthdayInCalendar(date);
        //
        //fill About
        fillAboutInfo(text);
        click(By.xpath("//button[@type='submit']"));
    }

    click(By.xpath("//mat-select[@placeholder='Food Preferences']"));
    List<WebElement> els = driver.findElements(By.xpath("//mat-pseudo-checkbox"));
        for(
    WebElement el :els)

    {
        if (!el.isSelected()) {
            el.click();
        }
    }

    Actions action = new Actions(driver);
        action.sendKeys(Keys.ESCAPE).

    build().

    perform();

    click(By.xpath("//mat-select[@placeholder='Marital Status']"));

    click(By.xpath("//span[contains(text(),'Single')]"));
        Thread.sleep(3000);

    click(By.xpath("//mat-select[@placeholder='Languages']"));
    els =driver.findElements(By.xpath("//mat-pseudo-checkbox"));
        for(
    WebElement el :els)

    {
        if (!el.isSelected()) {
            el.click();
        }
    }
        action.sendKeys(Keys.ESCAPE).

    build().

    perform();

    type(By.xpath("//textarea[@id='description']"),text);

    click(By.xpath("//mat-select[@placeholder='Gender']"));

    click(By.xpath("//span[contains(text(),'Female')]"));
}

    private void selectBirthdayInCalendar(Calendar date) throws InterruptedException {
        click(By.xpath("//button[@aria-label='Open calendar']"));
        //
        // searchYear
        click(By.xpath("//div[@class='mat-calendar-arrow']"));
        //while we cant see our year in list
        while (driver.findElements(By.xpath("//div[contains(text(),'" + date.get(Calendar.YEAR) + "')]")).isEmpty()) {
            //click previous year page
            click(By.xpath("//button[@aria-label='Previous 20 years']"));
        }
        click(By.xpath("//div[contains(text(),'" + date.get(Calendar.YEAR) + "')]"));
        //search month
        String month = new SimpleDateFormat("MMM", Locale.ENGLISH).format(date.getTime());
        click(By.xpath("//div[contains(text(),'" + month.toUpperCase() + "')]"));
        //search date
        click(By.xpath("//div[contains(text(),'" + date.get(Calendar.DATE) + "')]"));


    }
