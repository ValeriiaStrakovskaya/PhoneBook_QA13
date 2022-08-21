package manager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class AppManager {

    Logger logger = LoggerFactory.getLogger(AppManager.class);

   // WebDriver wd;
    EventFiringWebDriver wd;
    HelperUser user;
    HelperContact contact;



    public void init(){

        WebDriverManager.chromedriver().setup();
        logger.info("Test starts on ChromeDriver");
       // wd =  new ChromeDriver();
        wd=new EventFiringWebDriver(new ChromeDriver());
        wd.register(new MyListener());
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home");
        user=new HelperUser(wd);
        contact = new HelperContact(wd);

    }

    public HelperUser getUser() {
        return user;
    }
    public HelperContact contact() {
        return contact;
    }

    public void stop(){
wd.quit();

    }
}
