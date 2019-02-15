package pages;

import config.Config;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import base.BaseTest;
import static base.Driver.driver;

/**
 * Created by sushant on 05/10/18.
 */
public class POCreate extends BaseTest {


    public void createPO() throws InterruptedException{
        Date date = new Date();

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, 1);
        date = c.getTime();
        System.out.println("Tommorw date:" +date);
        Thread.sleep(7000);
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String point = Config.Channel.channel+"unicommerce.com/purchaseOrders#viewName=Approved&filters%5B0%5D%5Bid%5D=statusFilter&filters%5B0%5D%5BselectedValues%5D%5B%5D=APPROVED";

        driver.navigate().to(point);
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver,50);
        WebElement link ;
       // link = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=' Create PO']")));
        // link.click();
        driver.findElement(By.xpath("//div[@class=\"rightSideNavbar rfloat10 clearfix\"]//button[@class='uni-btn-primary purchaseOrder']")).click();

        System.out.println("Create PO button clicked:");

        WebElement expDtate ;
        expDtate= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='expiryDate']")));
        expDtate.click();
        expDtate.sendKeys("20/02/2022");

        WebElement deliveryDate;
        deliveryDate= driver.findElement(By.xpath("//input[@name='deliveryDate']"));
        deliveryDate.click();

        String dDdate= dateFormat.format(date);
        System.out.println("Generated Date:" + dDdate);
        deliveryDate.sendKeys(dDdate);


        driver.findElement(By.xpath("(//span [@class='select2-chosen'] )[3]")).click();

        WebElement vendorCode = driver.findElement(By.xpath("(//input[@class='select2-input'])[5]"));
        vendorCode.click();
        vendorCode.sendKeys(Config.VendorCode);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='select2-result-label']")).click();
        Thread.sleep(3000);

        WebElement SkuDropdown1 =driver.findElement(By.xpath("//*[text()='Name/ SKU/ Vendor SKU']"));
        Thread.sleep(2000);
        SkuDropdown1.click();
        SkuDropdown1.sendKeys(Config.SKU);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='select2-result-label']")).click();

        System.out.println("sku selected");

        Thread.sleep(2000);

        driver.findElement(By.xpath("//td[@data-col-id='quantity']//input[@class='simpleInputCellRender']")).sendKeys("1");

        System.out.println("qty updated");
        Thread.sleep(2000);


        driver.findElement(By.xpath("(//*[text()='Create Purchase Order'])[2]")).click();

        System.out.println(" -:*** PO Created Successfully ***:- ");

        Thread.sleep(10000);

        driver.findElement(By.xpath("//button[@id='sendForApproval']")).click();

        System.out.println("PO Send for Approval: " );

        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[@id='approvePO']")).click();

        System.out.println("PO Approved Successfully: " );

        Thread.sleep(3000);


    }

}
