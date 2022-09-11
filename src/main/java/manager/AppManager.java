package manager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
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
    String browser;



    public void init(){

        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        logger.info("Test starts on ChromeDriver");
       // wd =  new ChromeDriver();
        if(browser.equals((BrowserType.CHROME))){
            wd=new EventFiringWebDriver(new ChromeDriver());
            logger.info("Tests start on Chrome");
        }else if(browser.equals(BrowserType.FIREFOX)){
            wd=new EventFiringWebDriver(new FirefoxDriver());
            logger.info("Tests start on Firefox");
        }

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

    public AppManager(String browser) {
        this.browser = browser;
    }

    public HelperContact contact() {
        return contact;
    }

    public void stop(){
//wd.quit();

    }
}
