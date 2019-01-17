package Test;

import config.Config;
import org.testng.annotations.Test;
import pages.CreatePicklist;
import pages.LoginPageClass;
import pages.Picklist_temp;
import pages.RecurrentTask;
import pages.SaleOrderPageClass;
import pages.TenentSelectionPageClass;
import util.BaseTest;
import static util.Driver.driver;

/**
 * Created by sushant on 17/07/18.
 */
public class TestOrderProcessing extends BaseTest {

    LoginPageClass objLoginPage = new LoginPageClass();
    SaleOrderPageClass objSaleOrderPage = new SaleOrderPageClass();
    TenentSelectionPageClass objTenentSelectionPage = new TenentSelectionPageClass();
    RecurrentTask objRecuurentTask = new RecurrentTask();
    CreatePicklist objCreatePicklist = new CreatePicklist(objSaleOrderPage);
    Picklist_temp objPicklistTemp = new Picklist_temp();

    @Test(priority = 1)
    public void navigationTest() throws InterruptedException {
        driver.navigate().to(Config.URL.url);
        System.out.println("Driver Value at 1st Test:" + driver);
        Thread.sleep(2000);

    }

    @Test(priority = 2)
    public void logingTest() throws InterruptedException {
        objLoginPage.LogingPage();
        System.out.println("Loging");
    }

    @Test(priority = 3)
    public void talentSelectionTest() throws InterruptedException {
        objTenentSelectionPage.tenentSelectionPage();
        System.out.println("Tenent Selected");
        Thread.sleep(2000);
    }

    @Test(priority = 4)
    public void saleOrderPageTest() throws InterruptedException {
        objSaleOrderPage.addSaleOrder();
       // System.out.println("Order:" + objSaleOrderPage.orderIds);
        //  String ExpectedURL="https://stgenterprise1.unicommerce.com/order/orderitems?orderCode=SO1004965#viewName=All&filters%5B0%5D%5Bid%5D=saleOrderCodeFilter&filters%5B0%5D%5Btext%5D=SO1004965";
        // Assert.assertTrue(objSaleOrderPage.AddSaleOrder(),"Failed");
    }

    @Test(priority = 5)
    public void runTaskTest() throws InterruptedException {
        objRecuurentTask.taskRun();
        System.out.println("Runing Task: ");
        Thread.sleep(8000);

    }


    @Test(priority = 6)
    public void createPicklistTest() throws InterruptedException {
        objCreatePicklist.createInvoicingPicklist();
        System.out.println("TC Create Invoicing Picklist is Running");
    }

   /* @Test(priority = 6)
    public void createTempPicklist() throws InterruptedException{
        objPicklistTemp.tempPiclistCreate();
        System.out.println("TC Create Temp Pickllist is Running : ");

    }*/





}

