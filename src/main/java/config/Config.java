package config;

import util.BaseTest;
import static util.Driver.driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by sushant on 17/07/18.
 */
public class Config extends BaseTest
    {

        public static class URL {

            public static String url = "https://stgauth.unicommerce.com/";
        }

        public static class  Browser{
            public static String browser="firefoxDriver";
        }


        public static class Tenents{

            public static WebElement teneteName = driver.findElement(By.xpath("//*[@account-code='qa1']"));
        }

       public static class Endpoint{
            public static  String endpoint ="https://qa1.unicommerce.com/";
        }

        public static class Channel{
            public static String channel ="https://qa1.";
        }


    }
