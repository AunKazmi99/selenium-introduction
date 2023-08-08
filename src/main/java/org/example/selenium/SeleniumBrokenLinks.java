package org.example.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class SeleniumBrokenLinks {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        SoftAssert softAssert = new SoftAssert();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        List<WebElement> linkElements = driver.findElements(By.cssSelector("div#gf-BIG table tbody tr td li a"));

        for (WebElement linkElement : linkElements)
        {
            String url = linkElement.getAttribute("href");
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            int responseCode = conn.getResponseCode();
            softAssert.assertTrue(responseCode<400,"The Link with Text '"+linkElement.getText()+"' is Broken with code "+responseCode);
//            if (responseCode > 400)
//            {
//                System.out.println("The Link with Text '"+linkElement.getText()+"' is Broken with code "+responseCode);
//                //Assert.assertTrue(false);
//                Assert.fail();
//            }
        }
        softAssert.assertAll();
    }
}
