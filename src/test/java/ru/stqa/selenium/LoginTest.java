package ru.stqa.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.selenium.pages.HomePage;
import ru.stqa.selenium.pages.LoginRegistrationPage;

import java.util.concurrent.TimeUnit;

public class LoginTest extends TestBase {
    private HomePage homepage;
    private LoginRegistrationPage loginRegistrationPage;

    @BeforeMethod
    public void initPageObjects() {
        homepage = PageFactory.initElements(driver, HomePage.class);
        loginRegistrationPage=PageFactory.initElements(driver,LoginRegistrationPage.class);
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void loginAsRegisteredUser() {
        String email = "steve.anderson@gmail.com";
        String password = "na5fl1qon";
        homepage.clickButtonLogin();
        loginRegistrationPage.putTextToFieldEmail(email)
                .putTextToFieldPassword(password)
                .clickButtonSubmit();
        Assert.assertEquals(true,driver.findElement(By.xpath("//span[@class='ng-star-inserted']")).isEnabled());
    }

    @Test
    public void registeration() {
        String email = "anyNewUser@email.com";
        String password = "anyNewPassword";
        homepage.clickButtonRegistration();
        loginRegistrationPage.putTextToFieldEmail(email)
                .putTextToFieldPassword(password)
                .putTextToFieldRepeatPassword(password)
                .clickButtonSubmit();
        Assert.assertEquals(true,driver.findElement(By.xpath("//span[@class='ng-star-inserted']")).isEnabled());
    }

}
