package pages;

import base.BaseTest;
import static base.Driver.driver;
import config.Config;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by sushant on 19/02/18.
 */
public class SaleOrderPageClass extends BaseTest {


        public static String singleOrderId;
        public static String multiOrderId;


    public static String addSaleOrder() throws InterruptedException {


        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        System.out.println("Order Page Loading");
        String point = Config.Channel.channel+"unicommerce.com/orders/add";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        System.out.println(" Task is run Successfully ");
        driver.navigate().to(point);
        driver.findElement(By.xpath("//label[@for=\"AutoGenerateOrderCode\"]")).click();
        driver.findElement(By.xpath("//input[@name=\"displayOrderCode\"]")).sendKeys("TestOrder");
        WebElement channelDropdown = driver.findElement(By.xpath("//div[@id=\"channelName_single\"]"));
        channelDropdown.click();
        driver.findElement(By.xpath("//*[text()=\"CUSTOM\"]")).click();
        driver.findElement(By.xpath("//*[text()='COD']")).click();
        WebElement FacilityDropdown = driver.findElement(By.xpath("//span[text()='Select Facility']"));
        FacilityDropdown.click();
        FacilityDropdown.sendKeys("mumbai");
        driver.findElement(By.xpath("//div[@class='select2-result-label']")).click();
        WebElement CustomerDropdown = driver.findElement(By.xpath("(//span [@class=\"select2-chosen\"] )[6]"));
        CustomerDropdown.click();
        CustomerDropdown.sendKeys("sushantTest");
        driver.findElement(By.xpath("//div[@class='select2-result-label']")).click();

        WebElement SkuDropdown = driver.findElement(By.xpath("//*[text()='Name or SKU Code']"));
        SkuDropdown.click();
        SkuDropdown.sendKeys(Config.SKU);
        driver.findElement(By.xpath("//div[@class='select2-result-label']")).click();
        driver.findElement(By.xpath("(//*[text()='Create Order'])[2]")).click();
        String orderID = driver.findElement(By.xpath("//value[@class='mightOverflow']//span[@class='coolTip']")).getAttribute("text");
        singleOrderId = orderID.toString();
        System.out.println("orderID:" + singleOrderId);
        System.out.println("Order created sucessfully: ");
        Thread.sleep(1000);
        //setOrderIds(orderIds);

       return singleOrderId;
    }

    public static String addMultiItemSaleOrder() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        System.out.println("Order Page Loading");
        String point = Config.Channel.channel+"unicommerce.com/orders/add";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        System.out.println(" Task is run Successfully ");
        driver.navigate().to(point);
        driver.findElement(By.xpath("//label[@for=\"AutoGenerateOrderCode\"]")).click();
        driver.findElement(By.xpath("//input[@name=\"displayOrderCode\"]")).sendKeys("TestOrder");
        WebElement channelDropdown = driver.findElement(By.xpath("//div[@id=\"channelName_single\"]"));
        channelDropdown.click();
        driver.findElement(By.xpath("//*[text()=\"CUSTOM\"]")).click();
        driver.findElement(By.xpath("//*[text()='COD']")).click();
        WebElement FacilityDropdown = driver.findElement(By.xpath("//span[text()='Select Facility']"));
        FacilityDropdown.click();
        FacilityDropdown.sendKeys("mumbai");
        driver.findElement(By.xpath("//div[@class='select2-result-label']")).click();
        WebElement CustomerDropdown = driver.findElement(By.xpath("(//span [@class=\"select2-chosen\"] )[6]"));
        CustomerDropdown.click();
        CustomerDropdown.sendKeys("sushantTest");
        driver.findElement(By.xpath("//div[@class='select2-result-label']")).click();

        WebElement SkuDropdown = driver.findElement(By.xpath("//*[text()='Name or SKU Code']"));
        SkuDropdown.click();
        SkuDropdown.sendKeys(Config.SKU);
        driver.findElement(By.xpath("//div[@class='select2-result-label']")).click();
        //Thread.sleep(2000);



        driver.findElement(By.xpath("//*[@id=\"addRowItemTable\"]/span")).click();
        Thread.sleep(1000);
        WebElement SkuDropdown2 = driver.findElement(By.xpath("//*[text()='Name or SKU Code']"));
        SkuDropdown2.click();
        SkuDropdown2.sendKeys(Config.SKU2);
        driver.findElement(By.xpath("//div[@class='select2-result-label']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("(//*[text()='Create Order'])[2]")).click();
        String orderID = driver.findElement(By.xpath("//value[@class='mightOverflow']//span[@class='coolTip']")).getAttribute("text");
        multiOrderId= orderID.toString();
        System.out.println("orderID:" + multiOrderId);
        System.out.println("Order created sucessfully: ");
        Thread.sleep(1000);
        //setOrderIds(orderIds);

        return multiOrderId;
    }





}









