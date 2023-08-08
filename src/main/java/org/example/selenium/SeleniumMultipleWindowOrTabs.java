package org.example.selenium;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class SeleniumMultipleWindowOrTabs {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/angularpractice/");
        //https://rahulshettyacademy.com
        driver.switchTo().newWindow(WindowType.TAB);
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> iterator = windows.iterator();
        String parentId = iterator.next();
        String childId = iterator.next();
        driver.switchTo().window(childId);
        driver.get("https://rahulshettyacademy.com");
        String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']"))
                .get(1).getText();
        driver.switchTo().window(parentId);
        WebElement element = driver.findElement(By.cssSelector("[name='name']:nth-child(2)"));
        element.sendKeys(courseName);
        driver.findElement(By.cssSelector(".btn.btn-success")).click();

        File src = element.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("C:\\Users\\AunAbbas\\Desktop\\SeleniumUdemyResources\\SeleniumWebDriverDownload\\ScreenShot1.png"));

        System.out.println(element.getRect().getDimension().getHeight());
        System.out.println(element.getRect().getDimension().getWidth());
        driver.quit();


    }
}
