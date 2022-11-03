package HepsiBuradaFinalCaseSunumu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.time.Duration;
import java.util.Set;

public class HepsiBuradaUyelikGirisliTest {

    @Test
    public void SepeteUrunEklenmesi() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-translate");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-gpu");
        options.addArguments("--ignore,certificate-errors");
        options.addArguments("--allow-insecure-localhost");
        options.addArguments("--acceptInsecureCerts");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--disable-extensions");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1-Kullanıcı Hepsiburada.com sitesini ziyaret eder.

        driver.get("http:www.hepsiburada.com");

        //2-Kullanıcı giriş işlemi yapılır.

        WebElement kullanici= driver.findElement(By.xpath("//*[@id=\"myAccount\"]"));
        Actions actions= new Actions(driver);
        actions.moveToElement (kullanici).build().perform();

        WebElement login= driver.findElement(By.xpath("//*[@id=\"login\"]"));
        login.click();

        WebElement EmailKutusu= driver.findElement(By.xpath("//input[@autocomplete='username']"));
        EmailKutusu.sendKeys("abdulkadir-olcan@hotmail.com");


        driver.findElement(By.xpath("//*[@id=\"btnLogin\"]")).click();


        WebElement PassWord= driver.findElement(By.xpath("//*[@id=\"txtPassword\"]"));
        PassWord.sendKeys("Githup1357");
        driver.findElement(By.xpath("//*[@id=\"btnEmailSelect\"]")).click();

        //3-Yönlendirmeden sonra anasayfada kullanıcı giriş işleminin yapıldığı doğrulanır

        WebElement logoElementi= driver.findElement(By.xpath("//*[@id=\"myAccount\"]/span/a/span[2]"));
        Assert.assertTrue(logoElementi.isDisplayed());

        //4-Kullanıcı, burada satın almak istediği ürün için arama yapacaktır.
        WebElement searchBox = driver.findElement(By.xpath("//input[@class=\"desktopOldAutosuggestTheme-UyU36RyhCTcuRs_sXL9b\"]"));
        searchBox.click();
        searchBox.sendKeys("Bilgisayar");
        searchBox.sendKeys(Keys.ENTER);


        //5-Kullanıcı, Arama sonucunda ekrana gelen ürün listesinden (veya tek bir sonuç da dönmüş olabilir) ürün seçer.

        Thread.sleep(5000);
        Set<String> windowAllWindows = driver.getWindowHandles();

        for (String window:windowAllWindows) {
            driver.switchTo().window(window);
        }
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


        //6-Seçilen ürün için 2 tane farklı satıcıdan ürün seçilip sepete eklenir.
        Thread.sleep(9000);
        ((JavascriptExecutor) driver).executeScript("scroll(0,100)");
        Actions acs = new Actions(driver);
        WebElement web = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/div/div/div/div/div[2]/div[3]/a"));
        acs.moveToElement(web).build().perform();

        //7-Seçilen ürünün doğru olarak eklendiği ‘Sepetim’ sayfasında doğrulanmalıdır.

        Thread.sleep(9000);
        WebElement productAdd = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/div/div/div/div/div[2]/div[3]/a"));
        productAdd.click();




    }

}
