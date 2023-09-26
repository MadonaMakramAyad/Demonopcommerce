package StepsDefinitions;

import Pages.P02_LoginPage;
import Pages.P03_HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;

public class D02_LoginStepDefs{
    SoftAssert soft = new SoftAssert();
    P02_LoginPage loginPage = new P02_LoginPage();
    P03_HomePage homePage=new P03_HomePage();
    @Given("user go to Login page")
    public void LoginTab(){
        homePage.LoginTab();
    }
    @When("user enters Email Address {string}")
    public void userEntersEmailAddress(String Email) {
        loginPage.EnterEmailAddress(Email);
    }
    @And("User Clicks Password {string}")
    public void userClicksPassword(String Password) {
        loginPage.EnterPassword(Password);
    }
    @And("User Clicks on Login Button")
    public void userClicksOnLoginButton() {
        loginPage.LoginButton();
    }
    @Then("User Log in his account successfully")
    public void userLogInHisAccountSuccessfully() {
        soft.assertEquals(homePage.MyAccount().isDisplayed(),true);
        soft.assertAll();
        System.out.println("My Account is Displayed");
    }
    @Then("User Fail to go to his account")
    public void userFailToGoToHisAccount() {
        soft.assertEquals(loginPage.LoginFailed().isDisplayed(), true);
        String color = loginPage.LoginFailed().getCssValue("color");
        String expectedColor = "#e4434b";
        soft.assertEquals(color, expectedColor, "The color does not match the expected value.");
        System.out.println("FAAAil");
    }
}
