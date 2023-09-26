package StepsDefinitions;

import Pages.P03_HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;

public class D08_WishlistStepDef {
    P03_HomePage homePage = new P03_HomePage();
    SoftAssert soft =new SoftAssert();
    @Given("User Search for products")
    public void userSearchForProducts() {
        homePage.FindProducts();
    }
    @When("user clicks on wishlist")
    public void userClicksOnWishlist() throws InterruptedException {
        homePage.ClickOnWishList();
    }
    @Then("User confirm adding product to wishlist")
    public void userConfirmAddingProductToWishlist() {
        String rgbColor = homePage.WishlistSuccess();
        String actualColor = homePage.rgbToHex(rgbColor);
        String expectedColor = "#4bb07a"; // replace with the expected color
        soft.assertEquals(actualColor,expectedColor,"the product is green");
        soft.assertAll();
        System.out.println("Add to wish list");
    }
    @And("User wait to be sure product to add")
    public void userWaitToBeSureProductToAdd() throws InterruptedException {
        homePage.WaitWishlist();
    }
    @And("User go to Wishlist Tab")
    public void userGoToWishlistTab() {
        homePage.GotoWishlist();
    }
    @Then("User make sure about the quantity needed")
    public void userMakeSureAboutTheQuantityNeeded() throws InterruptedException {
        homePage.AssertQuantity();
        System.out.println("pass");
    }
}
