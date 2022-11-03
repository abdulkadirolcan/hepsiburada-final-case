package video1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.openqa.selenium.JavascriptExecutor;
import java.time.Duration;


public class HepsiBuradaKullaniciGirisYapilmadan {


    @Test
    public  void KullaniciGirisYapilmadan() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1-Kullanıcı Hepsiburada.com sitesini ziyaret eder.

        driver.get("http:www.hepsiburada.com");


        //2-Kullanıcı, Arama sonucunda ekrana gelen ürün listesinden (veya tek bir sonuç da dönmüş olabilir) ürün seçer.

       WebElement searchBox = driver.findElement(By.xpath("//div[@class='desktopOldAutosuggestTheme-DgkZjXtKHeqy6zTL8GSA']"));
        searchBox.click();
        searchBox.sendKeys("Bilgisayar");
        searchBox.sendKeys(Keys.ENTER);


        WebElement logoElementi= driver.findElement(By.xpath("//div[@class=\"searchResultSummaryBar-CbyZhv5896ASVcYBLKmx\"]"));
        Assert.assertTrue(logoElementi.isDisplayed());

        //3-Seçilen ürün için 2 tane farklı satıcıdan ürün seçilip sepete eklenir

        Thread.sleep(2000);
        ((JavascriptExecutor) driver).executeScript("scroll(0,800)");
        Actions ac = new Actions(driver);
        WebElement wb = driver.findElement(By.xpath("/html/body/div[3]/main/div[2]/div/div[6]/div[2]/div[2]/div[4]/div/div/div/div/div/div/ul/li[1]"));
        ac.moveToElement(wb).build().perform();
        Thread.sleep(3000);
        WebElement productOne = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/main[1]/div[2]/div[1]/div[6]/div[2]/div[2]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/div[1]/a[1]/div[2]/button[1]"));
        productOne.click();
        Thread.sleep(3000);


        WebElement wbTwo = driver.findElement(By.xpath("/html/body/div[3]/main/div[2]/div/div[6]/div[2]/div[2]/div[4]/div/div/div/div/div/div/ul/li[2]"));
        ac.moveToElement(wbTwo).build().perform();
        Thread.sleep(3000);
        WebElement productTwo = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/main[1]/div[2]/div[1]/div[6]/div[2]/div[2]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/div[1]/a[1]/div[2]/button[1]"));
        productTwo.click();
        //4-Seçilen ürünün doğru olarak eklendiği'Sepetim' sayfasında doğrulanmalıdır.

        Thread.sleep(5000);
        WebElement productAdd = driver.findElement(By.xpath("//*[@id=\"shoppingCart\"]"));
        productAdd.click();



}
}