package testCases;

import base.BaseTest;
import static base.Driver.driver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import config.Config;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CreateGRN;
import pages.LoginPageClass;
import pages.POCreate;
import pages.TenentSelectionPageClass;

/**
 * Created by sushant on 04/10/18.
 */
public class TestAddInventory extends BaseTest {

     ExtentReports extent;
    ExtentTest logger;


    LoginPageClass objLoginPage1 = new LoginPageClass();
    TenentSelectionPageClass objTenentSelectionPage1 = new TenentSelectionPageClass();
    POCreate objPOCreate = new POCreate();
    CreateGRN objCreateGRN = new CreateGRN();
    //Driver drivers = new Driver();




    @BeforeTest
    public void navigationTest() throws InterruptedException {

        driver.navigate().to(Config.URL.url);
        System.out.println("Driver Value at 1st Test:" + driver);
        Thread.sleep(2000);

    }


    @Test(priority = 1)
    public void logingTest() throws InterruptedException {
        objLoginPage1.LogingPage(Config.User,Config.Pass);

        System.out.println("Loging");
    }

    @Test(priority = 2)
    public void talentSelectionTest() throws InterruptedException {
        objTenentSelectionPage1.tenentSelectionPage();
        System.out.println("Tenent Selected");
        Thread.sleep(2000);
    }


    @Test(priority = 3)
    public void createPOTest() throws InterruptedException {
        objPOCreate.createPO();
        System.out.println("TC Create PO is Running");
    }


    @Test(priority = 4)
    public void createGRN() throws InterruptedException{
        objCreateGRN.CreateGRN();
        System.out.println("TC Create GRN is Running");
    }



}
