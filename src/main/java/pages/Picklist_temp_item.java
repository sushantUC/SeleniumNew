package pages;

import config.Config;
import java.util.ArrayList;
import java.util.HashSet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static util.Driver.driver;

/**
 * Created by sushant on 14/01/19.
 */
public class Picklist_temp_item {


    public void tempItemPicklistCreate () throws  InterruptedException {

        String point = Config.Channel.channel + "unicommerce.com/picklists/view/items?picklistCode=1000243";
        driver.navigate().to(point);
        Thread.sleep(4000);
        WebElement textBox = driver.findElement(By.xpath(
                "//div[@class='inputSearchBox scanBox posRelative lfloat5']//input[@class='search uni-input scanShipment']"));

        HashSet<String> itemCodes = new HashSet<String>();
        ArrayList<String > arrayList = new ArrayList<String>();


    }
    }
