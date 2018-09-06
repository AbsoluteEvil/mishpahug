package ru.stqa.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class LoginRegistrationPage extends PageBase {

    @FindBy(xpath = "//input[@placeholder='Email']")
    WebElement emailField;

    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement passwordField;

    @FindBy(xpath = "//input[@placeholder='Repeat password']")
    WebElement repeatPasswordField;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement buttonSubmit;

    @FindBy(xpath = "//button[@type='button']")
    WebElement buttonCancel;

    @FindBy(xpath = "//span[@class='link']")
    WebElement linkRegistrationOrLogin;



    public LoginRegistrationPage(WebDriver driver) {
        super(driver);
    }

    public LoginRegistrationPage putTextToFieldEmail(String text) {
        type(emailField,text);
        return this;
    }
    public LoginRegistrationPage putTextToFieldPassword(String text) {
        type(passwordField,text);
        return this;
    }
    public LoginRegistrationPage putTextToFieldRepeatPassword(String text) {
        type(repeatPasswordField,text);
        return this;
    }



    public LoginRegistrationPage clickButtonSubmit() {
        buttonSubmit.click();
        return this;
    }

    public LoginRegistrationPage switchRegistrationWithLogin(String text) {
        linkRegistrationOrLogin.click();
        return this;
    }


    public LoginRegistrationPage clickButtonCancel() {
        buttonCancel.click();
        return this;
    }

    public void waitForIt() {
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    }

}
