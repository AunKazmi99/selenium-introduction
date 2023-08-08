package org.example.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

public class SeleniumFluentWait {

    public static void main(String[] args){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        WebDriverWait explicitWait = new WebDriverWait(driver,Duration.ofSeconds(5));
        Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
                        .pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.cssSelector("div#start button")).click();

        WebElement foo = fluentWait.until(new Function<WebDriver, WebElement>(){
            @Override
            public WebElement apply(WebDriver driver) {
                if(driver.findElement((By.cssSelector("div#finish h4"))).isDisplayed())
                    return driver.findElement((By.cssSelector("div#finish h4")));
                    else return null;
            }
        });

        System.out.println(driver.findElement(By.cssSelector("div#finish h4")).getText());

    }
}
