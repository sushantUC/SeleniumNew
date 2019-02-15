package testCases;

import API.ApiRequest;
import base.BaseTest;
import static base.Driver.driver;
import config.Config;
import java.awt.*;
import java.io.IOException;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import pages.LoginPageClass;
import pages.RecurrentTask;
import pages.SaleOrderPageClass;
import pages.StagingPicklistClass;
import pages.TenentSelectionPageClass;
import util.TestUtil;

/**
 * Created by sushant on 13/02/19.
 */
public class TestStageOrderProcessing extends BaseTest {


    LoginPageClass objLoginPage = new LoginPageClass();
    SaleOrderPageClass objSaleOrderPage = new SaleOrderPageClass();
    TenentSelectionPageClass objTenentSelectionPage = new TenentSelectionPageClass();
    RecurrentTask objRecuurentTask = new RecurrentTask();
    StagingPicklistClass objStagingPicklistClass = new StagingPicklistClass();
    ApiRequest objapiRequest = new ApiRequest();
    TestUtil util = new TestUtil();


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

    @Test(priority = 2)
    public void talentSelectionTest() throws InterruptedException {
        objTenentSelectionPage.tenentSelectionPage();
        System.out.println("Tenent Selected");
        Thread.sleep(2000);
    }

    @Test(priority = 3)
    public void saleOrderPageTest() throws InterruptedException {
        objSaleOrderPage.addMultiItemSaleOrder();
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
    public void createStatgingPicklistZone1Test() throws InterruptedException {
        objStagingPicklistClass.createStagingPicklist("DEFAULT");
        System.out.println("TC Create Invoicing Picklist is Running");
    }


    @Test(priority = 7)
    public void testgetPicklistDetailsAPI() throws InterruptedException, IOException, NullPointerException
    {
        objapiRequest.getPicklistDetailsStaging();
        System.out.println("TC Create Get Picklist details is Running");
    }


    @Test(priority =8)
    public void testreciveStagingPicklistZone1Test() throws InterruptedException, IOException, AWTException {
        objStagingPicklistClass.receiveStagingPicklist();
        System.out.println("TC Create Received Picklist is Running");
    }


    /*-------------------------------- Zone 2 */

    @Test(priority = 9)
    public void createStatgingPicklistZone2Test() throws InterruptedException {
        objStagingPicklistClass.createStagingPicklist("ZONE1");
        System.out.println("TC Create Invoicing Picklist is Running");
    }


    @Test(priority = 10)
    public void testGetOauthToken2() throws InterruptedException, IOException
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
    @Test(priority = 11)
    public void testgetPicklistDetailsAPI2() throws InterruptedException, IOException, NullPointerException
    {
        objapiRequest.getPicklistDetailsStaging();
        System.out.println("TC Create Get Picklist details is Running");
    }

    @Test(priority =12)
    public void testreciveStagingPicklistZone2Test() throws InterruptedException, IOException, AWTException {
        objStagingPicklistClass.receiveStagingPicklist();
        System.out.println("TC Create Received Picklist is Running");
    }


    @org.testng.annotations.Test(priority = 13)
    public void testDispatchShipment()throws InterruptedException, IOException, AWTException {
       // objStagingPicklistClass.markDispatch();
        System.out.println("TC Dispatch Shipment Completted ");
    }


}
