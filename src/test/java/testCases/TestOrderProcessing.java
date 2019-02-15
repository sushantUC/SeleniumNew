package testCases;

import API.ApiRequest;
import base.BaseTest;
import static base.Driver.driver;
import config.Config;
import java.awt.*;
import java.io.IOException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.InvoicingPicklistClass;
import pages.LoginPageClass;
import pages.Picklist_temp;
import pages.RecurrentTask;
import pages.SaleOrderPageClass;
import pages.TenentSelectionPageClass;
import util.TestUtil;

/**
 * Created by sushant on 17/07/18.
 */
public class TestOrderProcessing extends BaseTest {

    LoginPageClass objLoginPage = new LoginPageClass();
    SaleOrderPageClass objSaleOrderPage = new SaleOrderPageClass();
    TenentSelectionPageClass objTenentSelectionPage = new TenentSelectionPageClass();
    RecurrentTask objRecuurentTask = new RecurrentTask();
    InvoicingPicklistClass objInvoicingPicklistClass = new InvoicingPicklistClass();//objSaleOrderPage
    Picklist_temp objPicklistTemp = new Picklist_temp();
    ApiRequest objapiRequest = new ApiRequest() ;
    TestUtil util= new TestUtil();




    @BeforeTest
    public void navigationTest() throws InterruptedException {
        driver.navigate().to(Config.URL.url);
        System.out.println("Driver Value at 1st Test:" + driver);
        Thread.sleep(2000);

    }


    @Test(priority = 1)
    public void logingTest() throws InterruptedException {
        objLoginPage.LogingPage(Config.User, Config.Pass);
        System.out.println("Loging");
    }

  /*  @DataProvider
    public Object[][] getTestData(){
        TestUtil.getTestData("excelData.xlsx");

        return new Object[0][];
    }*/
    @Test(priority = 2)
    public void talentSelectionTest() throws InterruptedException {
        objTenentSelectionPage.tenentSelectionPage();
        System.out.println("Tenent Selected");
        Thread.sleep(2000);
    }

    @Test(priority = 3)
    public void saleOrderPageTest() throws InterruptedException {
        objSaleOrderPage.addSaleOrder();
    }

    @Test(priority = 4)
    public void runTaskTest() throws InterruptedException {
        objRecuurentTask.taskRun();
        System.out.println("Runing Task: Sale Order Processor ");
        Thread.sleep(8000);
    }



    @Test(priority = 5)
    public void testGetOauthToken() throws InterruptedException, IOException
    {
        try {
            objapiRequest.getOauthApi();
            System.out.println("get oauth token: "+objapiRequest.tokenAPI);
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("TC Create Get Oauth is Running");
        }
    }

    @Test(priority = 6)
    public void createPicklistTest() throws InterruptedException {
        objInvoicingPicklistClass.createInvoicingPicklist();
        System.out.println("TC Create Invoicing Picklist is Running");
    }




    @Test(priority = 7)
    public void testgetPicklistDetailsAPI() throws InterruptedException, IOException, NullPointerException
    {
        objapiRequest.getPicklistDetailsInvoicing();
        System.out.println("TC Create Get Picklist details is Running");
    }


    @Test(priority =8)
    public void testrecivedPicklist() throws InterruptedException, IOException, AWTException {
        objInvoicingPicklistClass.receivePicklist();
        System.out.println("TC Create Received Picklist is Running");
    }

    @Test(priority = 9)
    public void testDispatchShipment()throws InterruptedException, IOException, AWTException {
        objInvoicingPicklistClass.markDispatch();
        System.out.println("TC Dispatch Shipment Completted ");
    }


}

