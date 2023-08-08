package org.example.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class SeleniumCheckboxes {

    public static void main(String[] args)
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        Assert.assertFalse(driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected());
        //System.out.println(driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected());
        driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
        Assert.assertTrue(driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected());
        //System.out.println(driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected());
        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());

        /*driver.findElement(By.cssSelector("input[name='checkBoxOption1']")).click(); //Clicking on the First Checkbox to Select it
        Assert.assertTrue(driver.findElement(By.cssSelector("input[name='checkBoxOption1']")).isSelected()); //Verifying the selection
        driver.findElement(By.cssSelector("input[name='checkBoxOption1']")).click(); //Clicking second time to unselect it
        Assert.assertFalse(driver.findElement(By.cssSelector("input[name='checkBoxOption1']")).isSelected()); //Verifying it is unselected
    */
        //System.out.println(driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled());
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        //System.out.println(driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled());
        if(driver.findElement(By.id("ctl00_mainContent_view_date2")).getAttribute("style").contains("1")){
            System.out.println("It's Enabled");
            Assert.assertTrue(true);
    }
        else {
            System.out.println("Not Enabled");
            Assert.assertTrue(false);
        }
    }

}
