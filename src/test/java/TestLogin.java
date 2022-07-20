import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;



public class TestLogin {
    WebDriver wd;



    @BeforeMethod
    public void init(){
        WebDriverManager.chromedriver().setup();
        wd =  new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home");

    }

    @Test
    public void LoginPositiveTest(){
        //open form
        wd.findElement(By.xpath("//*[text()='LOGIN']")).click();

        //fill form
        WebElement element =wd.findElement(By.xpath("//input[1]"));
        element.click();
        element.clear();
        element.sendKeys("Strakovskaya.valeriia@gmail.com");
        element =wd.findElement(By.xpath("//input[2]"));
        element.click();
        element.clear();
        element.sendKeys("BigBubbles~182");
        //click login button
        element= wd.findElement(By.xpath("//button[text()=' Login']"));
        element.click();

        //assert if logout button present
        Assert.assertTrue(wd.findElement(By.xpath("//button")) !=null);


    }

        @Test
    public void LoginNegativeTest1(){
        wd.findElement(By.xpath("//*[text()='LOGIN']")).click();

        //fill form with wrong e-mail
        WebElement element =wd.findElement(By.xpath("//input[1]"));
        element.click();
        element.clear();
        element.sendKeys("Strakovskaya.valeriiagmail.com");
        element =wd.findElement(By.xpath("//input[2]"));
        element.click();
        element.clear();
        element.sendKeys("BigBubbles~182");
        //click login button
        element= wd.findElement(By.xpath("//button[text()=' Login']"));
        element.click();
        //assert if login button isn't present

boolean test=true;
        try {
            wd.findElement(By.xpath("//button[text()=' Login']"));
        } catch (Exception e) {
            test = false;
        }
Assert.assertFalse(test);


    }
    @Test
    public void LoginNegativeTest2(){
        wd.findElement(By.xpath("//*[text()='LOGIN']")).click();

        //fill form with wrong password
        WebElement element =wd.findElement(By.xpath("//input[1]"));
        element.click();
        element.clear();
        element.sendKeys("Strakovskaya.valeriia@gmail.com");
        element =wd.findElement(By.xpath("//input[2]"));
        element.click();
        element.clear();
        element.sendKeys("jhgj");
        //click login button
        element= wd.findElement(By.xpath("//button[text()=' Login']"));
        element.click();
        //assert if login button isn't present

        boolean test=true;
        try {
            wd.findElement(By.xpath("//button[text()=' Login']"));
        } catch (Exception e) {
            test = false;
        }
        Assert.assertFalse(test);


    }
    @Test
    public void LoginNegativeTest3(){
        wd.findElement(By.xpath("//*[text()='LOGIN']")).click();
        //fill form with empty fields
        WebElement element =wd.findElement(By.xpath("//input[1]"));
        element.click();
        element.clear();
        element =wd.findElement(By.xpath("//input[2]"));
        element.click();
        element.clear();
        //click login button
        element= wd.findElement(By.xpath("//button[text()=' Login']"));
        element.click();
        //assert if login button isn't present

        boolean test=true;
        try {
            wd.findElement(By.xpath("//button[text()=' Login']"));
        } catch (Exception e) {
            test = false;
        }
        Assert.assertFalse(test);



    }
    @AfterMethod
    public void TearDown(){
        //     wd.quit();
    }
}
