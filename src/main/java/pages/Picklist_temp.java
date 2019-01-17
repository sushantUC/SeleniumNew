package pages;

import config.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import util.BaseTest;
import static util.Driver.driver;

/**
 * Created by sushant on 02/08/18.
 */
public class Picklist_temp extends  BaseTest{

    public void tempPiclistCreate () throws  InterruptedException{

        String point = Config.Channel.channel+"unicommerce.com/picklists/view/items?picklistCode=PK44";
        driver.navigate().to(point);
        Thread.sleep(4000);
        WebElement textBox= driver.findElement(By.xpath("//div[@class='inputSearchBox scanBox posRelative lfloat5']//input[@class='search uni-input scanShipment']"));


         for (int i= 1; i<=18; i++) {
             String value = "skun423";
             System.out.println(i);
             textBox.sendKeys(value);
             textBox.sendKeys(Keys.ENTER);

             Thread.sleep(1000);
         }
       // textBox.clear();
           //  Thread.sleep(1000);

        for (int j=1; j<=28; j++) {
            String sku2 = "skun838";
            System.out.println(j);
            textBox.sendKeys(sku2);
            textBox.sendKeys(Keys.ENTER);
        }



             Thread.sleep(1000);
             for (int k=1; k<=28; k++) {
                 String sku3 = "skun1079";
                 System.out.println(k);
                 textBox.sendKeys(sku3);
                 textBox.sendKeys(Keys.ENTER);
                 Thread.sleep(1000);
             }


    }


}
