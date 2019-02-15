package pages;

import base.BaseTest;
import static base.Driver.driver;
import config.Config;
import java.util.concurrent.TimeUnit;
import util.TestUtil;

/**
 * Created by sushant on 19/07/18.
 */
public class TenentSelectionPageClass extends BaseTest {
   Config config= new Config();

    public void tenentSelectionPage() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_Wait, TimeUnit.SECONDS);
        Config.Tenents.teneteName.click();
        Thread.sleep(4000);
    }
}