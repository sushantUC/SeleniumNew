package base;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 * Created by sushant on 17/07/18.
 */
public class BaseTest {

   // Config config= new Config();
   ExtentReports ext;
    ExtentTest test;



@BeforeSuite
    public void setUp() throws InterruptedException {

        Driver.initialize();
    }

    @AfterSuite
    public void cleanup(){
       //Driver.quit();
      System.out.println("Driver Closed: " +Driver.driver);
    }




}
