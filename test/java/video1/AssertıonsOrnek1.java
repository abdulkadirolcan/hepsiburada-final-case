package video1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.time.Duration;

public class AssertıonsOrnek1 {

      @Test
    public  void  test1(){
     //1. Launch browser
          WebDriverManager.chromedriver().setup();
          WebDriver driver = new ChromeDriver();
          driver.manage().window().maximize();
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

     //2. Navigate to url 'http://automationexercise.com'
          driver.get("http:www.automationexercise.com");
     //3. Verify that home page is visible successfully
          WebElement Logo= driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
          Assert.assertTrue(Logo.isDisplayed());
     //4. Click on 'Signup / Login' button
            WebElement signUp= driver.findElement(By.xpath("//a[@href='/login']"));
            signUp.click();
     //5. Verify 'Login to your account' is visible
            WebElement LoginYazisi= driver.findElement(By.xpath("//h2[text()='Login to your account']"));
            Assert.assertTrue(LoginYazisi.isDisplayed());
     //6. Enter correct email address and password
            WebElement EmailKutusu= driver.findElement(By.xpath("//input[@data-qa='login-email']"));
            EmailKutusu.sendKeys("a.kadir@hotmail.com");

            WebElement PassWord= driver.findElement(By.xpath("//input[@data-qa='login-password']"));
            PassWord.sendKeys("12345");
            //7.Click'Login' button
            driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();
            //8. Verify that 'Logged in as username' is visible
          WebElement LoggedYazisi= driver.findElement(By.xpath("//a[text()=' Logged in as ']"));
          Assert.assertTrue(LoggedYazisi.isDisplayed());

     //9. Click 'Logout' button
          driver.findElement(By.xpath("//a[@href='/logout']")).click();
     //10. Verify that user is navigated to login page
          String expectedUr="https://www.automationexercise.com/login";
          String actualUrl= driver.getCurrentUrl();
          Assert.assertEquals(expectedUr,actualUrl);
     //11. Close driver
          driver.close();

}
}