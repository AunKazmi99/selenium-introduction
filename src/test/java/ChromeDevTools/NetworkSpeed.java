package ChromeDevTools;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.Connection;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v116.network.Network;
import org.openqa.selenium.devtools.v116.network.model.ConnectionType;
import org.openqa.selenium.mobile.NetworkConnection;

import javax.sound.midi.Soundbank;
import java.util.Optional;

public class NetworkSpeed {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\AunAbbas\\Desktop" +
                "\\SeleniumUdemyResources\\SeleniumWebDriverDownload" +
                "\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        //ChromeDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        devTools.send(Network.enable(Optional.empty(),Optional.empty(),
                Optional.empty()));
        devTools.send(Network.emulateNetworkConditions(false,3000, 20000, 10000,
                Optional.of(ConnectionType.ETHERNET)));
        devTools.addListener(Network.loadingFailed(), loadingFailed -> {
            System.out.println(loadingFailed.getErrorText());
            System.out.println(loadingFailed.getTimestamp());
        });

        long startTime = System.currentTimeMillis();

        /*driver.get("http://google.com");
        driver.findElement(By.name("q")).sendKeys("netflix", Keys.ENTER);
        Thread.sleep(3000);
        driver.findElements(By.cssSelector(".LC20lb")).get(0).click();
        System.out.println(driver.findElement(By.tagName("h1")).getText());*/

        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.xpath("//button[@routerlink='/library']")).click();

        long endTime = System.currentTimeMillis();
        System.out.println("The Test took "+ (endTime-startTime)/1000 + " seconds");
    }
}
