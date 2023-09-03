package ChromeDevTools;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

import java.util.HashMap;
import java.util.Map;

public class Localization {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\AunAbbas\\Desktop" +
                "\\SeleniumUdemyResources\\SeleniumWebDriverDownload" +
                "\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        Map<String ,Object> coordinates= new HashMap<>();
        coordinates.put("latitude",40);
        coordinates.put("longitude",3);
        coordinates.put("accuracy",1);

        driver.executeCdpCommand("Emulation.setGeolocationOverride",coordinates);

        driver.get("http://google.com");
        driver.findElement(By.name("q")).sendKeys("netflix", Keys.ENTER);
        Thread.sleep(3000);
        driver.findElements(By.cssSelector(".LC20lb")).get(0).click();
        System.out.println(driver.findElement(By.tagName("h1")).getText());
    }
}
