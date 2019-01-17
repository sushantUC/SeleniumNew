package pages;

import config.Config;
import java.util.concurrent.TimeUnit;
import util.BaseTest;
import static util.Driver.driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by sushant on 19/02/18.
 */
public class SaleOrderPageClass extends BaseTest {

    By MainManue = By.xpath("//li[@class=\"mainMenuIcon mainMenuSelected\"]/a[@href='/orders']");

    By GetSOCode = (By.xpath("//svg[@width=\"18\"]"));
    public String orderIds;

    public String getOrderIds() {
        return orderIds;
    }

    public void setOrderIds(String orderIds) {
        this.orderIds = orderIds;
    }

    public void addSaleOrder() throws InterruptedException {
        String point = Config.Channel.channel+"unicommerce.com/orders/add";

        System.out.println("Task is running..:");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        System.out.println(" Task is run Successfully ");
        driver.navigate().to(point);
        Thread.sleep(4000);
        WebElement checkbox = driver.findElement(By.xpath("//label[@for=\"AutoGenerateOrderCode\"]"));
        checkbox.click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name=\"displayOrderCode\"]")).sendKeys("TestOrder");
        WebElement channelDropdown = driver.findElement(By.xpath("//div[@id=\"channelName_single\"]"));
        channelDropdown.click();

        driver.findElement(By.xpath("//*[text()=\"CUSTOM\"]")).click();

        driver.findElement(By.xpath("//*[text()='COD']")).click();
        WebElement FacilityDropdown = driver.findElement(By.xpath("//span[text()='Select Facility']"));
        FacilityDropdown.click();

        FacilityDropdown.sendKeys("mumbai");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='select2-result-label']")).click();

        WebElement CustomerDropdown = driver.findElement(By.xpath("(//span [@class=\"select2-chosen\"] )[6]"));
        CustomerDropdown.click();
        CustomerDropdown.sendKeys("sushantTest");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='select2-result-label']")).click();

        WebElement SkuDropdown = driver.findElement(By.xpath("//*[text()='Name or SKU Code']"));
        SkuDropdown.click();
        SkuDropdown.sendKeys("skun580");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='select2-result-label']")).click();
        driver.findElement(By.xpath("(//*[text()='Create Order'])[2]")).click();
        String orderID = driver.findElement(By.xpath("//value[@class='mightOverflow']//span[@class='coolTip']"))
                .getAttribute("text");
        orderIds = orderID.toString();
        System.out.println("orderID:" + orderIds);
        System.out.println("Order created sucessfully: ");
        Thread.sleep(1000);

        setOrderIds(orderIds);

        //return orderIds;
    }
}









