package pages;

import API.ApiRequest;
import base.BaseTest;
import static base.Driver.driver;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import config.Config;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import util.JsonUtil;


public class InvoicingPicklistClass extends BaseTest {

    public static String manualPicklistCode;


    public  String createInvoicingPicklist() throws InterruptedException {

        String Generated =SaleOrderPageClass.singleOrderId;
        System.out.println("Generated Order Id: " +Generated);
        String picklistEndPoint = Config.Endpoint.endpoint + "picklists/manualPicklist#";
        driver.get(picklistEndPoint);

        Thread.sleep(8000);
        WebElement filter = driver.findElement(By.xpath("(//div[@class='filterButtonDiv rfloat'])[1]"));
        filter.click();
        System.out.println("fileter clicked0");
        Thread.sleep(1000);
        try {

            filter.findElement(By.xpath("//input[@id='filterInput-orderCodeFilter']"))
                    .sendKeys(Generated);
        }
        catch (StaleElementReferenceException e) {
            e.printStackTrace();
        }
        Thread.sleep(1000);
        System.out.println("fileter clicked1");
        filter.findElement(By.xpath("//div[@class='btn uni-btn-small uni-btn-primary rfloat margint11 applyFilter']")).click();
        System.out.println("apply clicked");


        Thread.sleep(2000);
        WebElement checkBox1 = driver.findElement(By.xpath("//span[@class='dtCheckbox inputSelect-head']"));
        checkBox1.click();
        Thread.sleep(2000);
        checkBox1.findElement(By.xpath("//div[@class='btnDropdown posRelative module-header-dropdown']")).click();
        checkBox1.findElement(By.xpath("//button[@id='createPicklist']")).click();
        Thread.sleep(2000);
        manualPicklistCode= driver.findElement(By.xpath("//*[@id=\"sidebar\"]/accordion/acc-row[1]/acc-body/div/value[1]/span")).getText();
        System.out.println(" Picklist Create with Code: " + manualPicklistCode);

        return manualPicklistCode;

    }



        public void receivePicklist() throws InterruptedException, IOException, AWTException {

            driver.findElement(By.xpath("//div[@id='ReceivePickList']")).click();
            System.out.println(" Picklist received sucessfully ");
            WebElement itemScanBox = driver.findElement(By.xpath("//input[@id='masterScan']"));
            String picklistDetailsResponse = ApiRequest.picklistDetails;
            System.out.println("get picklist details value: " + picklistDetailsResponse);
            JsonObject picklistDetailsJson = (JsonObject) JsonUtil.stringToJson(picklistDetailsResponse);
            System.out.println(picklistDetailsJson);
            System.out.println(
                    picklistDetailsJson.get("pickInstructions").getAsJsonObject().get(Config.Shelf1).getAsJsonObject()
                            .get(Config.SKU).getAsJsonObject().get("validItemCodes"));
            JsonArray validItemCode = (JsonArray) picklistDetailsJson.get("pickInstructions").getAsJsonObject()
                    .get(Config.Shelf1).getAsJsonObject().get(Config.SKU).getAsJsonObject().get("validItemCodes");
            System.out.println(validItemCode);
            /* Iterator<JsonElement> iterator= validItemCode.iterator();
               while (iterator.hasNext()){
                    System.out.println("sout: " +iterator.next());
                }*/

            for (int i = 1; i <= 1; i++) {
                for (int j = 1; j <= 1; j++) {
                    System.out.println(validItemCode.get(i).getAsBigInteger());
                    validItemCode.get(i).getAsBigInteger().toString();
                    itemScanBox.sendKeys(validItemCode.get(i).getAsBigInteger().toString());
                    System.out.println("item code scanned: ");
                    itemScanBox.sendKeys(Keys.ENTER);
                    System.out.println("enter");
                    Thread.sleep(500);

                }
            }

            Thread.sleep(1000);
        }













































        public void markDispatch() throws InterruptedException,IOException, AWTException{

            System.out.println("Mark dispatch is ruuning");
            Robot rb =new Robot();
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//li[@id='subTabHeader-shipments']")).click();
            System.out.println("shipment tab clicked");
            driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//span[@class='PrintShipmentIcon icon icon icon_print-shipment iconStyle lfloartr23 iconBtn']")).click();
            System.out.println("Label print successfully");


          //  rb.keyRelease(KeyEvent.VK_ESCAPE);
            driver.findElement(By.xpath("//a[@class='lfloat']")).click();
            System.out.println(" 1");
            rb.keyPress(KeyEvent.VK_ESCAPE);

            System.out.println(" ****1");
            rb.keyRelease(KeyEvent.VK_ESCAPE);


            System.out.println("ESCAP SENT1");
            Thread.sleep(10);

            driver.findElement(By.xpath("//span[@class='icon icon_mark-dispatched']")).click();
            System.out.println(" 2");
            rb.keyPress(KeyEvent.VK_ESCAPE);

            System.out.println(" ****2");
            rb.keyRelease(KeyEvent.VK_ESCAPE);


            System.out.println("ESCAP SENT2");
            Thread.sleep(10);
            driver.findElement(By.xpath("//button[@id='okButton']")).click();
            System.out.println("Marked dispatched successfully");

    }
}
