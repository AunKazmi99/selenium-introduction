package org.example.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class SeleniumWindowHandling {
    public static void main(String[] args) {
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--remote-allow-origins*=");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
        driver.findElement(By.cssSelector(".blinkingText")).click();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> ids = windows.iterator();
        String parentId = ids.next();
        String childId = ids.next();
        driver.switchTo().window(childId);

        String email = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim()
                .split(" ")[0];
        driver.switchTo().window(parentId);
        driver.findElement(By.cssSelector("#username")).sendKeys(email);


    }
}

