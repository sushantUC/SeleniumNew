package pages;

import API.ApiRequest;
import base.BaseTest;
import static base.Driver.driver;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import config.Config;
import java.awt.*;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import util.JsonUtil;

/**
 * Created by sushant on 13/02/19.
 */
public class StagingPicklistClass extends BaseTest{

    public static String manualPicklistCode;

    public  String createStagingPicklist(String zone) throws InterruptedException {

        String Generated =SaleOrderPageClass.multiOrderId;
        System.out.println("Generated Order Id: " +Generated);
        String picklistEndPoint = Config.Endpoint.endpoint + "picklists/manualPicklist#";
        driver.get(picklistEndPoint);
        Thread.sleep(5000);

        if(zone =="DEFAULT"){
            driver.findElement(By.xpath("//*[@id=\"viewList\"]/div/ul/li[2]/a")).click();
            System.out.println("Staging Tab selected");

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
            filter.findElement(
                    By.xpath("//div[@class='btn uni-btn-small uni-btn-primary rfloat margint11 applyFilter']")).click();
            System.out.println("apply clicked");
            WebElement checkBox1 = driver.findElement(By.xpath("//span[@class='dtCheckbox inputSelect-head']"));
            checkBox1.click();;
            checkBox1.findElement(By.xpath("//div[@class='btnDropdown posRelative module-header-dropdown']")).click();
            checkBox1.findElement(By.xpath("//button[@id='createPicklist']")).click();
            manualPicklistCode = driver
                    .findElement(By.xpath("//*[@id=\"sidebar\"]/accordion/acc-row[1]/acc-body/div/value[1]/span"))
                    .getText();
            System.out.println(" Picklist Create with Code: " + manualPicklistCode);

        } else {


            driver.findElement(By.xpath("//*[@id=\"viewList\"]/div/ul/li[2]/a")).click();
            System.out.println("Staging Tab selected");
            WebElement zoneFilter= driver.findElement(By.xpath("(//span[@class='select2-chosen'])[3]"));
            System.out.println("Zone Selected");
            zoneFilter.click();
            WebElement zoneTextBox= driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/div/input"));
            System.out.println("Zone fileter clicked");
            zoneTextBox.sendKeys(zone);
            System.out.println("data entered");
            driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/ul/li/div")).click();
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
            System.out.println("fileter clicked1");
            filter.findElement(
                    By.xpath("//div[@class='btn uni-btn-small uni-btn-primary rfloat margint11 applyFilter']")).click();
            System.out.println("apply clicked");
            WebElement checkBox1 = driver.findElement(By.xpath("//span[@class='dtCheckbox inputSelect-head']"));
            checkBox1.click();
            checkBox1.findElement(By.xpath("//div[@class='btnDropdown posRelative module-header-dropdown']")).click();
            checkBox1.findElement(By.xpath("//button[@id='createPicklist']")).click();
            manualPicklistCode = driver
                    .findElement(By.xpath("//*[@id=\"sidebar\"]/accordion/acc-row[1]/acc-body/div/value[1]/span"))
                    .getText();
            System.out.println(" Picklist Create with Code: " + manualPicklistCode);

        }
            return manualPicklistCode;

    }

    public void receiveStagingPicklist() throws InterruptedException, IOException, AWTException {

        Thread.sleep(2000);
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
        for (int i = 1; i <= 1; i++) {
            for (int j = 1; j <= 1; j++) {
                System.out.println(validItemCode.get(i).getAsBigInteger());
                validItemCode.get(i).getAsBigInteger().toString();
                itemScanBox.sendKeys(validItemCode.get(i).getAsBigInteger().toString());
                System.out.println("item code scanned: ");
                itemScanBox.sendKeys(Keys.ENTER);
                System.out.println("enter");


            }
        }

        Thread.sleep(1000);
    }
}
