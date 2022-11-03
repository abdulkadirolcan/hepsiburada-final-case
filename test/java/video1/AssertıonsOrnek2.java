package video1;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class AssertıonsOrnek2  {

    @Test
     public  void  test2(){
    //1. Launch browser
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    //2. Navigate to url 'http://automationexercise.com'
        driver.get("http:www.automationexercise.com");
    //3. Verify that home page is visible successfully
        WebElement logoElementi= driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(logoElementi.isDisplayed());
    //4. Click on 'Products' button
      driver.findElement(By.xpath("//a[@href='/products']")).click();
    //5. Verify user is navigated to ALL PRODUCTS page successfully
        String expectedUrl="https://www.automationexercise.com/products";
        String actoalUrl= driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actoalUrl);
    //6. Enter product name in search input and click search button
        WebElement aramaKutusu= driver.findElement(By.xpath("//input[@id='search_product']"));
        aramaKutusu.sendKeys("tshirt");
        driver.findElement(By.xpath("//button[@id='submit_search']")).click();
        //7. Verify 'SEARCHED PRODUCTS' is visible
        WebElement AramaYapildi= driver.findElement(By.xpath("//h2[@class='title text-center']"));
        Assert.assertTrue(AramaYapildi.isDisplayed());
    //8. close driver
        driver.close();




}
    }