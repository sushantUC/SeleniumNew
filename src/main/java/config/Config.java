package config;

import base.BaseTest;
import static base.Driver.driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by sushant on 17/07/18.
 */
public class Config extends BaseTest
    {


        public static String User ="sushant@unicommerce.com";
        public static String Pass= "skm@1990";
        public static String VendorCode="skm008";
        public static String SKU="sushant260";
        public static String Shelf1= "SS1";
        public static String SKU2="sushant183";
        public static String Shelf2= "SSS1";
        public static String TenentName="qa1";



        public static class URL {

            public static String url = "https://stgauth.unicommerce.com/";
        }

        public static class  Browser{
            public static String browser="firefoxDriver";
        }


        public static class Tenents{

            public static WebElement teneteName = driver.findElement(By.xpath("//*[@account-code='"+TenentName+"']"));
        }

       public static class Endpoint{
            public static  String endpoint ="https://"+TenentName+".unicommerce.com/";
        }

        public static class Channel{
            public static String channel ="https://"+TenentName+".";
        }


    }
