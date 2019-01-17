package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import util.BaseTest;
import static util.Driver.driver;

/**
 * Created by sushant on 08/10/18.
 */
public class CreateGRN extends BaseTest
{

    public void CreateGRN () throws InterruptedException
    {

        driver.findElement(By.xpath("//li[@id='subTabHeader-grns']")).click();

        System.out.println("GRN Added");

        driver.findElement(By.xpath("//button[@id='createGRN']")).click();

        WebElement invoiceNumber=  driver.findElement(By.xpath("//input[@name='vendorInvoiceNumber']"));
        invoiceNumber.sendKeys("231");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[@id='SaveButton']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[text()='+ Add Another Item']")).click();

        WebElement itemSKU= driver.findElement(By.xpath("(//span[text()='Name or SKU Code'])[1]"));
        itemSKU.click();
        itemSKU.sendKeys(" sendKeys(\"PRODCODE003\");");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='select2-result-label']")).click();

        driver.findElement(By.xpath("//input[@class='quantity simpleInputCellRender height25']")).sendKeys("11");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[@class='editUpdateButton saveGRNItem icon-ok']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[@class='printLabel icon icon_print']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//button[text()='Complete GRN']")).click();
        driver.findElement(By.xpath("//*[text()='Mark QC Complete']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()='Quality Check Complete']")).click();
        Thread.sleep(3000);

    }
}
