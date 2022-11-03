package video1;

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AssertıonsMetodu {

    public  static void main(String[] args){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1- http:www.amazon.com sayfasına gidin
        driver.get("http:www.amazon.com");
        //2- arama çubuğuna "Nutella" yazdirin
        WebElement AramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        AramaKutusu.sendKeys("Nutella");
        //3-Nutella yazdiktan sonra ENTER'a basarak arama işlemini yapin
        AramaKutusu.submit();
        //4- Bulunan sonuc sayisini yazdirin.
        WebElement SonucYaziElementi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));


        String YaziStr= SonucYaziElementi.getText();

        String BulunacakKelime="Kutella";

        /*if (YaziStr.contains(BulunacakKelime)) {
            System.out.println("Nutella testi PASSED");
        } else {
            System.out.println("Sonuc yazisi nutella icermiyor"+"/n Nutella testi FAILED");
        }  bu if ve elsenin yerin alttaki assert yazmak yeterlidir*/

        //Assert.assertTrue(YaziStr.contains(BulunacakKelime));








    }







}
