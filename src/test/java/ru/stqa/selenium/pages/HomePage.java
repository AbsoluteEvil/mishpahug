package ru.stqa.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/**
 * Sample page
 */
public class HomePage extends Page {

    @FindBy(how = How.TAG_NAME, using = "h1")
    @CacheLookup
    public WebElement header;


    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void fillRegistrationForm(String email, String password, String repeat) {
        //email
        type(By.xpath("//input[@placeholder='Email']"), email);
        //password
        type(By.xpath("//input[@placeholder='Password']"), password);
        //repeat
        type(By.xpath("//input[@placeholder='Repeat password']"), repeat);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void type(By locator, String text) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void fillUserInformation(String firstname, String lastname, String phone, String confession, Calendar date, String text) throws InterruptedException {
        //firstname
        type(By.xpath("//input[@id='inputFirstName']"), firstname);
        //lastname
        type(By.xpath("//input[@id='inputLastName']"), lastname);
        //phone
        type(By.xpath("//input[@id='inputPhoneNumber']"), phone);
        //confession
        if (confession == null) {
            click(By.xpath("//mat-select[@placeholder='Confession']"));
            click(By.xpath("//span[contains(text(),'Irreligious')]"));
        } else {
            click(By.xpath("//mat-select[@placeholder='Confession']"));
            click(By.xpath("//span[contains(text(),'Religious')]"));
        }
        //birthDate
        selectBirthdayInCalendar(date);
        //
        //fill About
        fillAboutInfo(text);
        Thread.sleep(3000);
        click(By.xpath("//button[@type='submit']"));
        Thread.sleep(3000);
    }

    private void fillAboutInfo(String text) throws InterruptedException {
        click(By.xpath("//mat-select[@placeholder='Food Preferences']"));
        List<WebElement> els = driver.findElements(By.xpath("//mat-pseudo-checkbox"));
        for (WebElement el : els) {
            if (!el.isSelected()) {
                el.click();
            }
        }
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ESCAPE).build().perform();
        click(By.xpath("//mat-select[@placeholder='Marital Status']"));
        click(By.xpath("//span[contains(text(),'Single')]"));
        Thread.sleep(3000);
        click(By.xpath("//mat-select[@placeholder='Languages']"));
        els = driver.findElements(By.xpath("//mat-pseudo-checkbox"));
        for (WebElement el : els) {
            if (!el.isSelected()) {
                el.click();
            }
        }
        action.sendKeys(Keys.ESCAPE).build().perform();
        type(By.xpath("//textarea[@id='description']"), text);
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
        Thread.sleep(3000);
        click(By.xpath("//div[contains(text(),'" + date.get(Calendar.YEAR) + "')]"));
        //search month
        Thread.sleep(3000);
        String month = new SimpleDateFormat("MMM", Locale.ENGLISH).format(date.getTime());
        click(By.xpath("//div[contains(text(),'" + month.toUpperCase() + "')]"));
        //search date
        Thread.sleep(3500);
        click(By.xpath("//div[contains(text(),'" + date.get(Calendar.DATE) + "')]"));
    }
}

