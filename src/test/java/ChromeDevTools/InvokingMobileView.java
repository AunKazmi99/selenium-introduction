import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v116.emulation.Emulation;

import java.util.Optional;

public class ChromeDevTools {

    public static void main(String[] args) throws InterruptedException{
        /*ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");*/
        System.setProperty("webdriver.chrome.driver","C:\\Users\\AunAbbas\\Desktop" +
                "\\SeleniumUdemyResources\\SeleniumWebDriverDownload" +
                "\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        //ChromeDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        
        devTools.send(Emulation.setDeviceMetricsOverride(600, 1000, 50, true,
                Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(),
                Optional.empty(), Optional.empty(), Optional.empty(),
                Optional.empty(), Optional.empty()));

        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.className("navbar-toggler-icon")).click();
        //driver.findElement(By.xpath("//a[@routerlink='/library']")).click();
        Thread.sleep(3000);
        driver.findElement(By.linkText("Library")).click();


    }
}
