package pages;

import util.BaseTest;
import static util.Driver.driver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;

/**
 * Created by sushant on 18/02/18.
 */
public class LoginPageClass extends BaseTest{

    public  LoginPageClass LogingPage(){

        System.out.println(" Driver: =" + driver);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.id("username")).sendKeys("sushant@unicommerce.com");
        driver.findElement(By.id("password")).sendKeys("skm@1990");
        driver.findElement(By.className("loginButton")).click();
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return this;
}


}

