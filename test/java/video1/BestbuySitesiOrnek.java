package video1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class BestbuySitesiOrnek {
    public  static void main(String[] args){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1-https://www.bestbuy.com adresine gidin
        driver.get("http:www.bestbuy.com");
        //2-cookies cıkarsa kabul et butonuna basın
        //3-sayfa da kac adet buton bulunduğunu yazdırın
        List<WebElement> buttonListesi=driver.findElements(By.tagName("button"));
        System.out.println(buttonListesi.size());
        //4-sayfadaki herbir buton üzerindeki yazıları yazdırın
        for (WebElement each: buttonListesi) {
            System.out.println(each.getText());
        }





    }
}
