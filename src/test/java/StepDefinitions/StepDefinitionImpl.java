/*
package StepDefinitions;

import PageObjectModels.*;
import TestComponents.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.io.IOException;

public class StepDefinitionImpl extends BaseTest {

    public LandingPage landingPage;
    public ProductCatalogue productCatalogue;
    public CartPage cartPage;
    public CheckoutPage checkoutPage;
    public ConfirmationPage confirmationPage;
    @Given("I landed on Ecommerce Page")
    public void i_landed_on_ecommerce_page() throws IOException {
        landingPage = launchApplication();
    }

    @Given("^Logged in with username (.+) and password (.+)$")
    public void logged_in_with_username_and_password(String email, String password){
        productCatalogue = landingPage.LoginApplication(email, password);
    }

    @When("^I add product (.+) in cart$")
    public void i_add_product_in_cart(String productName){
        productCatalogue.AddProductToCart(productName);
    }

    @When("^checkout (.+) and Submit the order$")
   public void checkout_and_submit_the_order(String productName){
        cartPage = productCatalogue.GoToCartPage();
        boolean match = cartPage.VerifyProductDisplay(productName);
        Assert.assertTrue(match);
        checkoutPage = cartPage.GoToCheckoutPage();
        checkoutPage.SelectCountry("Pakistan");
        confirmationPage = checkoutPage.SubmitOrder();
    }

    @Then("{string} message is shown on confirmationPage")
    public void message_is_shown_on_confirmation_page(String message){
        String confirmMessage = confirmationPage.VerifyConfirmationMessage();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase(message));
        driver.close();
    }
}
*/

package StepDefinitions;

import PageObjectModels.*;
import TestComponents.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.io.IOException;

public class StepDefinitionImpl extends BaseTest {

    private LandingPage landingPage;
    private ProductCatalogue productCatalogue;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private ConfirmationPage confirmationPage;

    @Given("I landed on Ecommerce Page")
    public void i_landed_on_ecommerce_page() throws IOException {
        landingPage = launchApplication();
        //landingPage = new LandingPage(driver); // Assuming LandingPage constructor requires a WebDriver parameter
        //landingPage.launchApplication();
    }

    @Given("^Logged in with username (.+) and password (.+)$")
    public void logged_in_with_username_and_password(String email, String password) {
        productCatalogue = landingPage.LoginApplication(email, password); // Assuming the login method returns a ProductCatalogue object
    }

    @When("^I add product (.+) in cart$")
    public void i_add_product_in_cart(String productName) {
        productCatalogue.AddProductToCart(productName);
    }

    @When("^checkout (.+) and Submit the order$")
    public void checkout_and_submit_the_order(String productName) {
        cartPage = productCatalogue.GoToCartPage();
        boolean match = cartPage.VerifyProductDisplay(productName);
        Assert.assertTrue(match);
        checkoutPage = cartPage.GoToCheckoutPage();
        checkoutPage.SelectCountry("Pakistan");
        confirmationPage = checkoutPage.SubmitOrder();
    }

    @Then("{string} message is shown on confirmationPage")
    public void message_is_shown_on_confirmation_page(String message) {
        String confirmMessage = confirmationPage.VerifyConfirmationMessage();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase(message));
        driver.close();
    }
}
