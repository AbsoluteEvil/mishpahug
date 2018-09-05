package ru.stqa.selenium;

import com.github.javafaker.Faker;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.selenium.pages.HomePageHelper;
import ru.stqa.selenium.pages.LoginRegistrationPage;
import ru.stqa.selenium.pages.ProfilePage;

import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class ProfileTest extends TestBase {

    private HomePageHelper homepage;
    private ProfilePage profilePage;
    private LoginRegistrationPage loginRegistrationPage;

    @BeforeMethod
    public void initPageObjects() {
        homepage = PageFactory.initElements(driver, HomePageHelper.class);
        profilePage = PageFactory.initElements(driver, ProfilePage.class);
        loginRegistrationPage=PageFactory.initElements(driver,LoginRegistrationPage.class);
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    @Test
    public void fillUserInformation() throws InterruptedException {
        Faker faker = new Faker(new Locale("en"));
        Calendar birthday = Calendar.getInstance();
        birthday.setTime(faker.date().birthday());
        String email = "steve.anderson@gmail.com";
        String password = "na5fl1qon";
        loginRegistrationPage.clickButtonLogin()
                .putTextToFieldEmail(email)
                .putTextToFieldPassword(password)
                .clickButtonSubmit();
        homepage.pressMenuButton();
        homepage.goToProfilePage();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        profilePage.clickEditButton();
        profilePage.selectBirthdayInCalendar(birthday);
    }
}
