package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.lang.String;


public class LoginTest {
String baseUrl = "https://magento.softwaretestingboard.com/";//url
    @Test
    public void launchApp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        WebElement lnkSignIn = driver.findElement(By.linkText("Sign In"));
        lnkSignIn.click();
        driver.findElement(By.name("login[username]")).sendKeys("alishajose34@gmail.com");
        driver.findElement(By.name("login[password]")).sendKeys("Burnside@1210");
        driver.findElement(By.id("send2")).click();
        Thread.sleep(3000);
        String expWelMsg = "Welcome, Alisha Jose!";
        String actWelMsg = driver.findElement(By.className("logged-in")).getText();
        Assert.assertEquals(actWelMsg,expWelMsg,"login failed");
    driver.quit();
    }
}
