package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContact extends TestBase{
@BeforeMethod
public void preCondition() {
    if (!app.getUser().isLogged()) {
        app.getUser().login((new User()
                .withEmail("Strakovskaya.valeriia@gmail.com")
                .withPassword("BigBubbles~182")));
    }
}
    @Test (groups = {"smoke;"})
    public void removeOneContact(){
int result = app.contact().removeOneContact();
        Assert.assertEquals(result,1);
    }
    @Test
    public void removeAllContacts(){
    app.contact().removeAllContacts();

Assert.assertTrue(app.contact().isNoContactsHere());
    }
}
