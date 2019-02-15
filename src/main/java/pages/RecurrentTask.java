package pages;

import config.Config;
import java.util.concurrent.TimeUnit;
import base.BaseTest;
import static base.Driver.driver;

/**
 * Created by sushant on 25/07/18.
 */
public class RecurrentTask extends BaseTest{



    public void taskRun() throws InterruptedException{


         String point = Config.Channel.channel+"unicommerce.com/data/tasks/recurrentTask/run?taskId=SaleOrderProcessor";
         driver.navigate().to(point);
         System.out.println("Task is running..:");
         driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
         System.out.println(" Task is run Successfully ");
        // driver.navigate().back();
         /*

        WebElement element = driver.findElement(By.xpath("//tr[@id='RECURRENT-SaleOrderProcessor']//div[@class='btn btn-small lfloat runtask']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
        System.out.println("Element0: " + element);
        Thread.sleep(4000);

        */

        /*WebElement element1 =driver.findElement(By.xpath("//tr[@id='RECURRENT-SaleOrderProcessor']//td[@class='section-operations']//div[@class='btn btn-small lfloat runtask']"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element1);
        System.out.println("Element1: " + element1);

        WebElement button =driver.findElement(By.xpath("//tr[@id='RECURRENT-SaleOrderProcessor']//td[@class='section-operations']//div[@class='btn btn-small lfloat runtask']"));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click();", button);*/

        Thread.sleep(9000);
    }
}
