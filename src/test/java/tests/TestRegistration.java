package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.time.Duration.*;

public class TestRegistration extends TestBase {

@BeforeMethod
public void preCondition(){
    if(isLogged()){
        logout();
    }
}

    @Test
    public void registrationPos(){

        int i= (int) ((System.currentTimeMillis()/1000)%3600);
        String email = "testName" + i + "@mail.com";
        String password = "BigBubbles~182";
        System.out.println("Email: " + email);
        openLoginRegistrationForm();
        fillLoginRegistrationForm(email,password);
        submitRegistration();
        Assert.assertTrue(isElementPresent(By.xpath("//button")));
    }

    @Test
    public void registrationNeg(){

        int i= (int) ((System.currentTimeMillis()/1000)%3600);
        String email = "testName" + i + "mail.com";
        String password = "BigBubbles~182";
        System.out.println("Email: " + email);


        openLoginRegistrationForm();
        fillLoginRegistrationForm(email,password);
        submitRegistration();

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
