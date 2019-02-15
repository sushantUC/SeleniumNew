package base;

import config.Config;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by sushant on 17/07/18.
 */
public class Driver {

    public static WebDriver driver;

    public static void initialize() throws InterruptedException {

       if (driver == null) {
            System.out.println("Driver Initiliazing :"+ driver);
            if(Config.Browser.browser.equalsIgnoreCase("firefoxDriver")){
                driver = new FirefoxDriver();
            System.out.println("DRV: " + driver);}
           else if (Config.Browser.browser.equalsIgnoreCase("chromeDriver")) {
                System.setProperty("webdriver.chrome.driver", "/Users/sushant/Documents/chromedriver");
                driver = new ChromeDriver();
            }
        }
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Thread.sleep(2000);

    }




   /* public static void close(){
        System.out.println("Browser Close");
        driver.close();
        driver=null;
    }

    public static void quit(){
        System.out.println("Browser Quit");
        driver.quit();
        driver=null;
    }*/

}