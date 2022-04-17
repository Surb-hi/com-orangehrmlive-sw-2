package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    //Use @before junit method for open a browser for method
    public void setup() {
        openbrowser(baseUrl);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {
        //username elements
        WebElement UsernameField = driver.findElement(By.id("txtUsername"));
        UsernameField.sendKeys("Admin");

        //password elements
        WebElement PasswordField = driver.findElement(By.xpath("//input[@id='txtPassword']"));
        PasswordField.sendKeys("admin123");

        //login elements
        WebElement LoginField = driver.findElement(By.xpath("//input[@id='btnLogin']"));
        LoginField.click();

        //actual elements
        WebElement actualresult = driver.findElement(By.xpath("//a[@id='welcome']"));
        String actualmsg = actualresult.getText().substring(0, 7);

        //expected result
        String expectedmsg = "Welcome 123";

        //actual and expected result
        Assert.assertEquals("not able to login", actualmsg, expectedmsg);
    }

    @After
    //Here After method for close the browser
    public void teardown() {
        closebrowser();

    }
}

