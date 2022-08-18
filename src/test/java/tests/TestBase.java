package tests;
import manager.AppManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class TestBase {
  // WebDriver wd;
public static AppManager app=new AppManager();
Logger logger= LoggerFactory.getLogger(TestBase.class);


    @BeforeSuite
    public void init(){

//        WebDriverManager.chromedriver().setup();
//        wd =  new ChromeDriver();
//        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home");
       // wd.manage().timeouts().
        app.init();
    }
    @BeforeMethod
    public void startLogger(Method method){
        logger.info("Start test------> " + method.getName());
    }

    @AfterMethod
    public void end(){
        logger.info("***********************");
    }

    @AfterSuite
    public void tearDown(){
           // wd.quit();
        app.stop();


    }

//    public void submitRegistration() {
//        click(By.xpath("//button[2]"));
//
//    }
//    public void submitLogin() {
//        click(By.xpath("//button[1]"));
//
//    }

//    public void pause(int millis){
//        try {
//            Thread.sleep(millis);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

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


//    public boolean isElementPresent(By locator){
//        return wd.findElements(locator).size()>0;
//
//    }

//    public boolean isLogged(){
//        return isElementPresent(By.xpath("//button[contains(text(),'Sign Out')]"));
//
//    }
//    public void logout(){
//        click(By.xpath("//button[contains(text(),'Sign Out')]"));
//
//    }
}
