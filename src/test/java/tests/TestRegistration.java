package tests;
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class TestRegistration extends TestBase {


@BeforeMethod(alwaysRun = true)
public void preCondition(){
    if(app.getUser().isLogged()){
        app.getUser().logout();
    }
}

    @Test
    public void registrationPos(){
        int i= (int) ((System.currentTimeMillis()/1000)%3600);
        String email = "testName" + i + "@mail.com";
        String password = "BigBubbles~182";
        logger.info("Reg test starts with: " + email + "and " +password);
        User data=new User().withEmail(email).withPassword(password);
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(data);
        app.getUser().submitRegistration();
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));
       // Assert.assertFalse(app.getUser().isLogged());
    }

    @Test
    public void registrationNeg(){

        int i= (int) ((System.currentTimeMillis()/1000)%3600);
        String email = "testName" + i + "mail.com";
        String password = "BigBubbles~182";
        System.out.println("Email: " + email);

        User data=new User().withEmail(email).withPassword(password);
        app.getUser(). openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(data);
        app.getUser(). submitRegistration();
        //Assert.assertFalse(app.getUser().isLogged());
        Assert.assertTrue(app.getUser().isWrongMessageFormat());
        Assert.assertTrue(app.getUser().isAlertPresent());




//        WebElement wait = new WebDriverWait(wd, ofSeconds(10))
//                .until(ExpectedConditions.alertIsPresent());
//        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//        String text = alert.getText();
//        alert.accept();

    }

//    public void submitRegistration() {
//        click(By.xpath("//button[2]"));
//
//    }
//
//    public void fillLoginRegistrationForm(String email,String password) {
//        type(By.xpath("//input[1]"),email);
//        type(By.xpath("//input[2]"),password);
//
//    }
//
//    public void openLoginRegistrationForm() {
//        // wd.findElement(By.xpath("//*[text()='LOGIN']")).click();
//        click(By.xpath("//*[text()='LOGIN']"));
//
//    }
//    public void click(By locator){
//        wd.findElement(locator).click();
//
//    }
//
//    public void type(By locator,String text){
//        if(text!=null) {
//            WebElement element = wd.findElement(locator);
//            element.click();
//            element.clear();
//            element.sendKeys(text);
//        }
//    }
//
//    public boolean isElementPresent(By locator){
//        return wd.findElements(locator).size()>0;
//
//    }

//    @AfterMethod
//    public void tearDown(){
//        //     wd.quit();
//    }

}
