package manager;
import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class HelperContact extends HelperBase {


    public HelperContact(WebDriver wd) {
        super(wd);
    }

    Logger logger = LoggerFactory.getLogger(HelperContact.class);

    public void openContactForm() {
        click(By.xpath("//a[.='ADD']"));
    }

    public void fillContactForm(Contact contact) {
        type(By.cssSelector("[placeholder='Name']"), contact.getName());
        type(By.cssSelector("[placeholder='Last Name']"), contact.getLastname());
        type(By.cssSelector("[placeholder='Phone']"), contact.getPhone());
        type(By.cssSelector("[placeholder='email']"), contact.getEmail());
        type(By.cssSelector("[placeholder='Address']"), contact.getAddress());
        type(By.cssSelector("[placeholder='description']"), contact.getDescription());
    }

    public void submitContactForm() {
        click(By.xpath("//button[.='Save']"));
    }

    public void removeContacts() {
        List<WebElement> list = wd.findElements(By.xpath("(//div[@class='contact-item_card__2SOIM'])"));
        int x = -1;
        for (WebElement e : list) {
            list.get(x + 1).click();
            click(By.xpath("//button[normalize-space()='Remove']"));
            pause(1000);

        }

    }

    public int countContacts() {
        return wd.findElements(By.xpath("(//div[@class='contact-item_card__2SOIM'])")).size();

    }

    public boolean isContactCreated(String phone) {

        try {
            WebElement element = wd.findElement(By.xpath("//h3[.='" + phone + "']"));
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }


    }

    public int removeOneContact() {
        int countBefore = countContacts();
        logger.info("Number of contacts before : " + countBefore);
        if (countBefore != 0) {
            String phone = wd.findElement(By.cssSelector(".contact-item_card__2SOIM h3")).getText();
            logger.info("The removed phone number is " + phone);
            click(By.cssSelector(".contact-item_card__2SOIM"));
            click(By.xpath("//button[.='Remove']"));
            pause(500);
        }
        int countAfter = countContacts();
        logger.info("Number of contacts after : " + countAfter);
        return countBefore - countAfter;
    }

  public void removeAllContacts() {
while(countContacts()!=0){
    removeOneContact();


//DON"T DO THIS!
//      List<WebElement> elements =wd.findElements(By.cssSelector(".contact-item_card__2SOIM"));
//    for(WebElement e:elements){
//        elements.remove(e);
}

    }


    public boolean isNoContactsHere() {
return shouldHave(By.cssSelector(".contact-page_message__2qafk h1"),"No Contacts here!",1000);
    }
}
