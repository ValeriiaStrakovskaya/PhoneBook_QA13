package tests;

import models.Contact;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContact extends TestBase{

    @BeforeMethod(alwaysRun = true)
    public void preCondition(){
        if(!app.getUser().isLogged()){
            app.getUser().login((new User()
                    .withEmail("Strakovskaya.valeriia@gmail.com")
                    .withPassword("BigBubbles~182")));
        }
    }





    @Test (invocationCount = 4,groups = {"smoke","regression"})
    public void addNewContactTest(){

        int i = (int)(System.currentTimeMillis()/1000)%3600;
        Contact contact = Contact.builder()
                .name("John")
                .lastname("Snow")
                .phone("12345" + i)
                .email("john" + i + "@mail.com")
                .address("Haifa")
                .description("friend")
                .build();

        app.contact().openContactForm();
        app.contact().fillContactForm(contact);
        app.contact().submitContactForm();
        app.contact().pause(3000);
//        if(app.contact().countContacts()>3){
//           app.contact().removeContacts();
//        }

        Assert.assertTrue(app.contact().isContactCreated(contact.getPhone()));
    }

    @AfterMethod
    public void TearDown(){
        //     wd.quit();
    }

}