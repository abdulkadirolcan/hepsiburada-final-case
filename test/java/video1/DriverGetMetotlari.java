package video1;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogExporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverGetMetotlari {
    public static void main(String [] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("https://www.amazon.com");

        System.out.println("sayfa title:"+ driver.getTitle());

        System.out.println(driver.getCurrentUrl());

        System.out.println("=========================================");
        System.out.println(driver.getPageSource());
        System.out.println("=========================================");

        System.out.println(driver.getWindowHandle());

    }
}
