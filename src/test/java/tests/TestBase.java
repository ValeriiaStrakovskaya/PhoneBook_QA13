package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class TestBase {
   WebDriver wd;
//public static AppManager app=new AppManager();

    @BeforeSuite
    public void init(){

        WebDriverManager.chromedriver().setup();
        wd =  new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home");
        wd.manage().timeouts().
    }
    @AfterSuite
    public void tearDown(){
            wd.quit();
    }

    public void submitRegistration() {
        click(By.xpath("//button[2]"));

    }
    public void submitLogin() {
        click(By.xpath("//button[1]"));

    }

    public void pause(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void fillLoginRegistrationForm(String email,String password) {
        type(By.xpath("//input[1]"),email);
        type(By.xpath("//input[2]"),password);

    }

    public void openLoginRegistrationForm() {
        // wd.findElement(By.xpath("//*[text()='LOGIN']")).click();
        click(By.xpath("//*[text()='LOGIN']"));

    }
    public void click(By locator){
        wd.findElement(locator).click();

    }

    public void type(By locator,String text){
        if(text!=null) {
            WebElement element = wd.findElement(locator);
            element.click();
            element.clear();
            element.sendKeys(text);
        }
    }

    public boolean isElementPresent(By locator){
        return wd.findElements(locator).size()>0;

    }

    public boolean isLogged(){
        return isElementPresent(By.xpath("//button[contains(text(),'Sign Out')]"));

    }
    public void logout(){
        click(By.xpath("//button[contains(text(),'Sign Out')]"));

    }
}
