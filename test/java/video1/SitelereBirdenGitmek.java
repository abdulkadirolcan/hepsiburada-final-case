package video1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SitelereBirdenGitmek {
    WebDriver driver;
    @BeforeAll
    public void setup (){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @AfterAll
    public void tearDown () { driver.close(); }


    @Test
    public void test1() {
        driver.get("http:www.amazon.com");
    }
    @Test
    public void test2() {
        driver.get("http:www.bestbuy.com");
    }
    @Test
    public void test3() {
        driver.get("http:www.facebook.com");
    }



}
