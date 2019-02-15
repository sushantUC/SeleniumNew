package testCases;

import API.ApiRequest;
import base.BaseTest;
import static base.Driver.driver;
import config.Config;
import java.awt.*;
import java.awt.event.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import pages.InvoicingPicklistClass;
import pages.LoginPageClass;
import pages.Picklist_temp;
import pages.RecurrentTask;
import pages.SaleOrderPageClass;
import pages.TenentSelectionPageClass;
import util.TestUtil;

/**
 * Created by sushant on 05/02/19.
 */
public class Test extends BaseTest {


    ApiRequest objapiRequest = new ApiRequest();
    LoginPageClass objLoginPage = new LoginPageClass();
    SaleOrderPageClass objSaleOrderPage = new SaleOrderPageClass();
    TenentSelectionPageClass objTenentSelectionPage = new TenentSelectionPageClass();
    RecurrentTask objRecuurentTask = new RecurrentTask();
    InvoicingPicklistClass objInvoicingPicklistClass = new InvoicingPicklistClass();
    Picklist_temp objPicklistTemp = new Picklist_temp();
    TestUtil util= new TestUtil();




    @BeforeTest
    public void navigationTest() throws InterruptedException {
        driver.navigate().to(Config.URL.url);
        System.out.println("Driver Value at 1st Test:" + driver);
        Thread.sleep(2000);

    }


    @org.testng.annotations.Test(priority = 1)
    public void logingTest() throws InterruptedException {
        objLoginPage.LogingPage(Config.User, Config.Pass);
        System.out.println("Loging");
    }

    /*  @DataProvider
      public Object[][] getTestData(){
          TestUtil.getTestData("excelData.xlsx");

          return new Object[0][];
      }*/
    @org.testng.annotations.Test(priority = 2)
    public void talentSelectionTest() throws InterruptedException {
        objTenentSelectionPage.tenentSelectionPage();
        System.out.println("Tenent Selected");
        Thread.sleep(2000);
    }


    @org.testng.annotations.Test(priority = 3)

        public void test() throws InterruptedException, AWTException {
        driver.get("https://qa1.unicommerce.com/order/shipments?orderCode=SO1007039&shipmentCode=03P1002623");
        Thread.sleep(1000);
        WebElement reprintLable=driver.findElement(By.xpath("//*[@id=\"shippingPackagesContainer\"]/div/div[1]/div[2]/a[2]/span"));
        reprintLable.click();
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(4000);
        Robot rb = new Robot();
        rb.keyPress(KeyEvent.VK_ESCAPE);
        Thread.sleep(2000);
        rb.keyRelease(KeyEvent.VK_ESCAPE);
        System.out.println("ESC pass");
        Thread.sleep(1000);

    }

   /* @org.testng.annotations.Test(priority = 3)
    public void testGetOauthToken() throws InterruptedException, IOException
    {
        try {
            objapiRequest.getOauthApi();
            System.out.println("get oauth token: "+objapiRequest.tokenAPI);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @org.testng.annotations.Test(priority = 4)
    public void testgetPicklistDetailsAPI() throws InterruptedException, IOException
    {
         objapiRequest.getPicklistDetails();



    }
    @org.testng.annotations.Test(priority =5)
    public void testrecivedPicklist() throws InterruptedException, IOException, AWTException {
        objCreatePicklist.receivePicklist();
    }*/
}
