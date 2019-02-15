package pages;

import base.BaseTest;
import static base.Driver.driver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import util.TestUtil;

/**
 * Created by sushant on 18/02/18.
 */
public class LoginPageClass extends BaseTest{


    public String verifyLogingPageTitle(){

        return driver.getTitle();
    }



    public  TenentSelectionPageClass LogingPage(String usr, String pass){

        System.out.println(" Driver: =" + driver);

        driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_Wait, TimeUnit.SECONDS);
        driver.findElement(By.id("username")).sendKeys(usr);
        driver.findElement(By.id("password")).sendKeys(pass);
        driver.findElement(By.className("loginButton")).click();
        driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_Wait, TimeUnit.SECONDS);

        return new TenentSelectionPageClass();
}

    public String validatePage(){
      String TagName= driver.findElement(By.xpath("//div[h2='Select the account you want to access']")).getText();
      String taxt = driver.findElement(By.xpath("//*[text()='Choose your company']")).getText();
      String a= taxt.trim();
        System.out.println("a: " + a);
        //System.out.println("Tag: " + TagName);
        return a;
    }





}

