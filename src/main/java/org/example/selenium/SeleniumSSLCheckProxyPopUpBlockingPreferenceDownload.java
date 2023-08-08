package org.example.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SeleniumSSLCheckProxyPopUpBlockingPreferenceDownload {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
//        Proxy proxy = new Proxy();
//        proxy.setHttpProxy("ipaddress:4444");
//        options.setCapability("proxy", proxy);
        options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.default_directory", "C:\\Users\\AunAbbas\\Desktop\\SeleniumUdemyResources\\SeleniumWebDriverDownload");
        options.setExperimentalOption("prefs", prefs);

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://expired.badssl.com/");
        System.out.println(driver.getTitle());
    }
}
