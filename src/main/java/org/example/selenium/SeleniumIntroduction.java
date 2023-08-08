package org.example.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class SeleniumIntroduction {

    public static void main(String[] args){

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://restaurant.innowi.com");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        //System.out.println(driver.findElement(By.cssSelector("span.checout-sidebar-logo")).getText());
        driver.findElement(By.id("username")).sendKeys("aun.abbas@innowi.com");
        driver.findElement(By.id("password")).sendKeys("testing123");
        //driver.findElement(By.className("btn-primary")).click();
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        driver.quit();
    }
}
