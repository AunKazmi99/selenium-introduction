package ChromeDevTools;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.util.List;

public class ConsoleLogCapture {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\AunAbbas\\Desktop" +
                "\\SeleniumUdemyResources\\SeleniumWebDriverDownload" +
                "\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        //ChromeDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.linkText("Browse Products")).click();
        driver.findElement(By.linkText("Selenium")).click();
        driver.findElement(By.cssSelector(".add-to-cart")).click();
        driver.findElement(By.linkText("Cart")).click();
        driver.findElement(By.id("exampleInputEmail1")).clear();
        driver.findElement(By.id("exampleInputEmail1")).sendKeys("2");


        LogEntries entries = driver.manage().logs().get(LogType.BROWSER);
        List<LogEntry> logs =entries.getAll();

        for (LogEntry e: logs){
            System.out.println(e.getMessage());
        }
    }
}
