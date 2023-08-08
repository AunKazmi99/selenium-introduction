package org.example.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class SeleniumRelativeLocators {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/angularpractice/");
        //driver.findElement(By.cssSelector("div[class='form-group'] input[name='name']"));
        System.out.println(driver.findElement(with(By.tagName("label")).
                above(driver.findElement(By.cssSelector("div[class='form-group'] input[name='name']")))).getText());
        System.out.println(driver.findElement(with(By.tagName("input"))
                .below(driver.findElement(By.cssSelector("[for=dateofBirth]")))).getAttribute("type"));
        System.out.println(driver.findElement(with(By.tagName("input"))
                .toLeftOf(driver.findElement(By.cssSelector("label[for='exampleCheck1']")))).getAttribute("class"));
        System.out.println(driver.findElement(with(By.tagName("label"))
                .toRightOf(driver.findElement(By.id("inlineRadio1")))).getText());
    }
}
