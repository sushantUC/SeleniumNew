package pages;

import config.Config;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import util.BaseTest;
import static util.Driver.driver;

/**
 * Created by sushant on 25/07/18.
 */
public class CreatePicklist extends BaseTest {

   SaleOrderPageClass objSaleOrder;
    public CreatePicklist(SaleOrderPageClass objSaleOrderPage) {
        this.objSaleOrder = objSaleOrderPage;
    }


    public void createInvoicingPicklist() throws InterruptedException {

   // System.out.println(" Generated OrderID : "+objSaleOrder.getOrderIds());

        System.out.println("Generated Order Id: " + objSaleOrder.getOrderIds());

        String point = Config.Channel.channel+".unicommerce.com/picklists/manualPicklist#";
        driver.navigate().to(point);

        Thread.sleep(6000);
        WebElement filter= driver.findElement(By.xpath("(//div[@class='filterButtonDiv rfloat'])[1]"));
        filter.click() ;
        System.out.println("fileter clicked0");
        Thread.sleep(1000);
        filter.findElement(By.xpath("//input[@id='filterInput-orderCodeFilter']")).sendKeys(objSaleOrder.getOrderIds());
        Thread.sleep(1000);
        System.out.println("fileter clicked1");
       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        filter.findElement(By.xpath("//div[@class='btn uni-btn-small uni-btn-primary rfloat margint11 applyFilter']")).click();
        System.out.println("apply clicked");
       // WebElement Nodata =driver.findElement(By.xpath("//*[text()='No data available']"));

      /*  if(driver.findElement(By.xpath("/*//*[text()='No data available']")).isDisplayed()){
            System.out.println("Package not fond");
            WebElement zoneFilter= driver.findElement(By.xpath("(//span[@class='select2-chosen'])[3]"));
            zoneFilter.sendKeys("ZONE1");
            System.out.println("Zone fileter clicked");
            Thread.sleep(1000);
            zoneFilter.findElement(By.xpath("(//div[@class='select2-search'])[2]")).click();
            Thread.sleep(1000);
            System.out.println("data entered");
            zoneFilter.click();
        }*/

        Thread.sleep(2000);
        WebElement checkBox1 = driver.findElement(By.xpath("//span[@class='dtCheckbox inputSelect-head']"));
        checkBox1.click();
        Thread.sleep(2000);
        checkBox1.findElement(By.xpath("//div[@class='btnDropdown posRelative module-header-dropdown']")).click();
        checkBox1.findElement(By.xpath("//button[@id='createPicklist']")).click();




        // WebElement textBox= driver.findElement(By.xpath("//div[@class='inputSearchBox scanBox posRelative lfloat5']//input[@class='search uni-input scanShipment']"));

        Thread.sleep(10000);

        driver.findElement(By.xpath("//div[@id='ReceivePickList']")).click();
        System.out.println(" Picklist received sucessfully ");

        String  [] itemCodeList ={"18101710147942","1810171014793","1810171014803"};


        WebElement itemScanBox = driver.findElement(By.xpath("//input[@id='masterScan']"));
        itemScanBox.click();
        Thread.sleep(100);

//

        for (int i=1; i<=2; i++){

        itemScanBox.sendKeys("1810171014812");
        System.out.println("item code scanned: ");

        itemScanBox.sendKeys(Keys.ENTER);
        System.out.println("enter");}

        Thread.sleep(10000);
        //driver.navigate().back();

        driver.findElement(By.xpath("//li[@id='subTabHeader-shipments']")).click();

        System.out.println("shipment tab clicked");

        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//span[@class='PrintShipmentIcon icon icon icon_print-shipment iconStyle lfloartr23 iconBtn']")).click();

        System.out.println("Label print successfully");

        Thread.sleep(10000);

        driver.findElement(By.xpath("//a[@class='lfloat']")).click();
        System.out.println("Navigate to shipment page ");

        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//span[@class='icon icon_mark-dispatched']")).click();

        driver.findElement(By.xpath("//button[@id='okButton']")).click();

        System.out.println("Marked dispatched successfully");
        Thread.sleep(10000);


    }
}
