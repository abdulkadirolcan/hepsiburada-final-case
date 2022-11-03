package video1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FacebookOrnek {

    public  static void main(String[] args){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    //Test Case
    //1- http:www.facebook.com sayfasına gidin
        driver.get("http:www.facebook.com");
    //2-cookies cikarsa kabul et butonuna basın
        //driver.findElement(By.xpath("//button[@title='Allow essential and optional cookies']")).click();
    //3-ad kutusuna rastgele bir isim girin
        WebElement AdKutusu=driver.findElement(By.xpath("//input[@class='inputtext _55r1 _6luy']"));
        AdKutusu.sendKeys("Kadir1");
    //4-soyad kutusuna rastgele bir soyisim girin
        /*WebElement SoyadKutusu=driver.findElement(By.xpath("//input[@class='inputtext _58mg _5dba _2ph-']"));
        SoyadKutusu.sendKeys("olc");
    //5-eposta kutusuna rastgele bir eposta girin
        WebElement EpostaKutusu=driver.findElement(By.xpath("//input[@id ='u_0_g_U0']"));
        EpostaKutusu.sendKeys("abdullah-ak@hotmail.com");*/
    //6-şifre kısmına rasgele bir şifre girin
        WebElement SifreKutusu=driver.findElement(By.xpath("//input[@class ='inputtext _55r1 _6luy _9npi']"));
        SifreKutusu.sendKeys("kadir1430");

    //7-girişyap butonuna basın
        driver.findElement (By.xpath("//button[@name ='login']")).click();

    //8-uyari olarak 'The email or mobile number you entered isn't connected to an account. Find
    //your account and log in' mesajının çıktısını test edin'
        WebElement SonucYazıElementi=driver.findElement(By.xpath("//div[@class ='_9ay7']"));
        String expectedSonucYazisi="The email or mobile number you entered isn't connected to an account. Find your account and log in";
        String ActualSonucYazisi=SonucYazıElementi.getText();
        if (expectedSonucYazisi.equals(ActualSonucYazisi)){
            System.out.println("girilemedi testi passed");
        } else {
            System.out.println("girilemedi testi failed");
        }

    //9-sayfayı kapatın
        driver.close();










    }


}
