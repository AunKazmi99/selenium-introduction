package TestNG;

import org.testng.annotations.*;

public class TestNGBasics3 {
    @Test
    public void TestCase1() {
        System.out.println("TestNGBasics2.TestCase1");
    }

    @Test(groups = {"Regression"})
    public void TestCase2() {
        System.out.println("TestNGBasics2.TestCase2");
    }

    @Test(groups = {"Smoke"})
    public void TestCase3() {
        System.out.println("TestNGBasics2.TestCase3");
    }

    @BeforeTest
    public void BeforeTest() {
        System.out.println("Pre-requisite");
    }

    @BeforeSuite
    public void BeforeSuite() {
        System.out.println("BeforeSuite.Pre-requisite");
    }

    @BeforeMethod
    public void BeforeMethod() {
        System.out.println("TestNGBasics2.BeforeMethod");
    }

    @AfterMethod
    public void AfterMethod() {
        System.out.println("TestNGBasics2.AfterMethod");
    }
}
