package StepsDefinitions;

import Pages.P03_HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;



public class D06_homeSlidersStepDef {
    P03_HomePage home = new P03_HomePage();
    SoftAssert soft = new SoftAssert();

    @Given("User select first slider")
    public void userSelectFirstSlider() {
        home.Sliders();
    }
    @When("User go to on first products page")
    public void userGoToOnFirstProductsPage() {
       home.clickProductPage1();
    }
    @Then("User order number of iPhone")
    public void userOrderNumberOfNokiaLamia() {
        String actualhref=home.GotoLinkProduct();
        String expectedhref ="https://demo.nopcommerce.com/iphone-6";
        soft.assertEquals(actualhref,expectedhref,"true");
        soft.assertAll();
    }
    @Given("User select Second slider")
    public void userSelectSecondSlider() {
        home.Sliders();
    }
    @When("User go to on second products page")
    public void userGoToOnSecondProductsPage()  {
        home.clickProductPage2();
    }
    @Then("User order number of nokia lamia")
    public void userOrderNumberOfIPhone() {
        String expectedUrl = "https://demo.nopcommerce.com/nokia-lumia-1020";
        String actualUrl =home.GoToUrl();
        soft.assertEquals(actualUrl, expectedUrl, "URL mismatch! Expected " + expectedUrl + " but was " + actualUrl);
        soft.assertAll();
    }


}
