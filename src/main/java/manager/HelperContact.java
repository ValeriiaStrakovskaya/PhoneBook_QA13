package manager;
import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class HelperContact extends HelperBase{
    public HelperContact(WebDriver wd) {
        super(wd);
    }
    public void openContactForm() {
        click(By.xpath("//a[.='ADD']"));
    }

    public void fillContactForm(Contact contact) {
        type(By.cssSelector("[placeholder='Name']"),contact.getName());
        type(By.cssSelector("[placeholder='Last Name']"),contact.getLastname());
        type(By.cssSelector("[placeholder='Phone']"),contact.getPhone());
        type(By.cssSelector("[placeholder='email']"),contact.getEmail());
        type(By.cssSelector("[placeholder='Address']"),contact.getAddress());
        type(By.cssSelector("[placeholder='description']"),contact.getDescription());
    }

    public void submitContactForm() {
        click(By.xpath("//button[.='Save']"));
    }

    public void removeContacts() {
        List<WebElement> list = wd.findElements(By.xpath("(//div[@class='contact-item_card__2SOIM'])"));
        int x=-1;
        for(WebElement e:list){
            list.get(x+1).click();
            click(By.xpath("//button[normalize-space()='Remove']"));
            pause(1000);

        }

    }

    public int countContacts(){
       return wd.findElements(By.xpath("(//div[@class='contact-item_card__2SOIM'])")).size();

    }

}
