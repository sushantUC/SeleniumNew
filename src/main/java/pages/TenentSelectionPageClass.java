package pages;

import config.Config;
import util.BaseTest;
import static util.Driver.driver;
import java.util.concurrent.TimeUnit;

/**
 * Created by sushant on 19/07/18.
 */
public class TenentSelectionPageClass extends BaseTest {
   Config config= new Config();

    public void tenentSelectionPage() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    // driver.findElement(By.xpath("//*[@account-code='stgenterprise1']")).click();
       Config.Tenents.teneteName.click();
       // driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        Thread.sleep(4000);
    }
}