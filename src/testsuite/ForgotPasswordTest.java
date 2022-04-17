package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordTest extends BaseTest {
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    //Use @before junit method for open a browser for method
    public void setup() {
        openbrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToForgotPasswordPageSuccessfully() {
        //username elements
        WebElement UsernameField = driver.findElement(By.id("txtUsername"));
        UsernameField.sendKeys("Admin");

        //password elements
        WebElement PasswordField = driver.findElement(By.xpath("//input[@id='txtPassword']"));
        PasswordField.sendKeys("admin12");

        //forgetpassword elements
        WebElement ForgetPasswordField = driver.findElement(By.xpath("//a[contains(text(),'Forgot your password?')]"));
        ForgetPasswordField.click();

        //actualresult
        WebElement actualresult=driver.findElement(By.xpath("//h1[contains(text(),'Forgot Your Password?')]"));
        String actualmsg=actualresult.getText();

        //Expectedresult
        String expectedmsg="Forgot Your Password?";

        //match actual and expected result
        Assert.assertEquals("forget password ",actualmsg,expectedmsg);
    }
}