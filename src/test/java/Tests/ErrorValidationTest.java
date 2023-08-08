package Tests;

import PageObjectModels.CartPage;
import PageObjectModels.ProductCatalogue;
import TestComponents.BaseTest;
import TestComponents.Retry;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ErrorValidationTest extends BaseTest {

    @Test(groups = {"ErrorHandling"},retryAnalyzer = Retry.class)
    public void loginErrorValidation(){

        landingPage.LoginApplication("aun12345@gmail.com","Asad19671999@");
        Assert.assertEquals("Incorrect email or password.",landingPage.getErrorMessage());
    }
    @Test
    public void productErrorValidation(){

        String productName = "ZARA COAT 3";
        ProductCatalogue productCatalogue = landingPage.LoginApplication("aun@gmail.com","Asad19671999@");
        productCatalogue.AddProductToCart(productName);
        CartPage cartPage = productCatalogue.GoToCartPage();
        boolean match = cartPage.VerifyProductDisplay("ZARA COAT 33");
        Assert.assertFalse(match);
    }
}