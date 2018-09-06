package ru.stqa.selenium;

import org.openqa.selenium.support.PageFactory;

import org.testng.annotations.BeforeMethod;

import ru.stqa.selenium.pages.HomePage;

public class UserTests extends TestBase {

    private HomePage homepage;

    @BeforeMethod
    public void initPageObjects() {
        homepage = PageFactory.initElements(driver, HomePage.class);
    }
/*
    @Test
    public void createUser() throws InterruptedException {
        Faker faker = new Faker(new Locale("en"));
        String email = faker.name().username() + "@gmail.com";
        String password = faker.internet().password(6,12);
        //open site
        driver.get(baseUrl);
        //click "Create Account" button
        homepage.click(By.xpath("//span[contains(text(),'Create Account')]"));
        homepage.fillRegistrationForm(email, password, password);
        //submit registration
        homepage.click(By.xpath("//span[contains(text(),'Registration')]"));
        System.out.println("User:" + email + " Password: " + password);
        Thread.sleep(3000);
        Assert.assertEquals(true,driver.findElement(By.xpath("//span[@class='ng-star-inserted']")).isEnabled());
    }

    @Test
    public void fillUserProfile() throws InterruptedException {
        login("steve.anderson@gmail.com","na5fl1qon");
        homepage.click(By.xpath("//span[@class='ng-star-inserted']"));
        homepage.click(By.xpath("//span[contains(text(),'Profile')]"));
        Faker faker = new Faker(new Locale("en"));
        Calendar birthday = Calendar.getInstance();
        birthday.setTime(faker.date().birthday());
        homepage.fillUserInformation(
                faker.name().firstName(),
                faker.name().lastName(),
                String.valueOf(faker.number().randomNumber()),
                null,
                birthday,
                faker.demographic().sex());
    }*/

}
