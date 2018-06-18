package appManager;


import model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import tests.TestBase;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void initContactCreation() {
        click(By.xpath("//*[@href='edit.php']"));
    }

    public void selectContact() {
        click(By.xpath("//*[@type='checkbox']"));
    }

    public void selectAllContacts() {
        click(By.xpath("//*[@onclick='MassSelection()']"));
    }

    public int getContactCount() {
        return driver.findElements(By.name("selected[]")).size();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public void createContact() {
        initContactCreation();
     /*   fillContactForm(new ContactData()
                .withName("name")
                .withLastname("lastname")
                .withMobile("89999999999")
                .withEmail("mail@mail.ru"));*/
        submit();
    }


}
