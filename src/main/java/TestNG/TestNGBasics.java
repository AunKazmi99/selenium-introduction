package TestNG;

import org.testng.annotations.*;

public class TestNGBasics {
    @AfterTest
    public void AfterTest(){
        System.out.println("Post-Requisite");
    }
    @Test(enabled = false)
    public void TestCase0() {
        System.out.println("TestNGBasics.TestCase0");
    }
    @Test(timeOut = 4000)
    public void TestCase1() {
        System.out.println("TestNGBasics.TestCase1");
    }

    @Test(groups = {"Regression"})
    public void TestCase2() {
        System.out.println("TestNGBasics.TestCase2");
    }

    @Test(groups = {"Smoke"})
    public void TestCase3() {
        System.out.println("TestNGBasics.TestCase3");
    }

    @Test(dependsOnMethods = {"TestCase1"})
    public void DifferentTest(){
        System.out.println("TestNGBasics.DifferentTest");
    }

    @BeforeTest
    public void BeforeTest(){
        System.out.println("Pre-requisite");
    }
    @Parameters({"name"})
    @Test
    public void parameters(String URL){
        System.out.println(URL);
    }

    @Test(dataProvider = "getData")
    public void dataProvider(String userName, String passWord){
        System.out.println(userName);
        System.out.println("**********************************************");
        System.out.println(passWord);
    }

    @DataProvider
    public Object[][] getData(){
        Object[][] data = new Object[3][2];
        data[0][0]="firstColumnUserName";
        data[0][1]="firstColumnPassWord";
        data[1][0]="secondColumnUserName";
        data[1][1]="secondColumnPassWord";
        data[2][0]="thirdColumnUserName";
        data[2][1]="thirdColumnPassWord";
        return data;
    }
}