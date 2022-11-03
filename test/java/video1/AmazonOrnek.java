package video1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AmazonOrnek {


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
        System.out.println(SonucYaziElementi.getText());


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.close();






    }















}
