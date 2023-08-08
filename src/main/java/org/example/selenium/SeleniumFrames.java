package org.example.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumFrames {
    public static void main(String[] args) {
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--remote-allow-origins*=");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebDriverWait explicitWait = new WebDriverWait(driver,Duration.ofSeconds(5));

        driver.get("https://jqueryui.com/droppable");
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
        //driver.findElement(By.cssSelector("div#draggable"));

        Actions action = new Actions(driver);
        WebElement source = driver.findElement(By.cssSelector("div#draggable"));
        WebElement target = driver.findElement(By.cssSelector("div#droppable"));
        action.dragAndDrop(source,target).build().perform();
        driver.switchTo().defaultContent();

    }
}
