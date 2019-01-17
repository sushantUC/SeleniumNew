package util;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import java.io.File;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

/**
 * Created by sushant on 17/07/18.
 */
public class BaseTest {

   // Config config= new Config();
   ExtentReports ext;
    ExtentTest test;



    @BeforeSuite
    public void Suite(){

        ext = new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtentReport.html", true);
        ext.loadConfig(new File(System.getProperty("user.drive")+"//externt-config.xml"));
    }

    @BeforeTest
    public void setUp() throws InterruptedException {


        ext.addSystemInfo("HostName", "Uniware");
        ext.addSystemInfo("Environment", "Automation Test");
        ext.addSystemInfo("User Name", "Sushant");
       // ext.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
        Driver.initialize();
    }

  @AfterTest
    public void cleanup(){
        Driver.close();

      System.out.println("Driver Closed: " +Driver.driver);
    }




}
