package StepsDefinitions;

import Pages.P01_RegisterPage;
import Pages.P03_HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;

public class D01_registerStepDef {
    SoftAssert soft=new SoftAssert();
    P01_RegisterPage registerPage=new P01_RegisterPage();
    P03_HomePage homePage=new P03_HomePage();
    @Given("user go to register page")
    public void goRegisterPage(){
        homePage.ClickOnRegisterTab();
    }
    @When("user Selects Gender")
    public void SelectGender(){
        registerPage.Female_Gender();
    }
    @And("User enters First name {string}")
    public void userEntersFirstName(String FirstName) {
        registerPage.EnterFirstName(FirstName);
    }
    @And("User enters Last name {string}")
    public void userEntersLastName(String LastName) {
        registerPage.EnterLastName(LastName);
    }
    @And("User Selects Day Of Birth {string}")
    public void userSelectsDayOfBirth(String Days) {
        registerPage.DaysOfBirth(Days);
    }
    @And("USer Selects Month of Birth {string}")
    public void userSelectsMonthOfBirth(String Month) {
        registerPage.MonthsOfBirth(Month);
    }
    @And("User Selects Year of Birth {string}")
    public void userSelectsYearOfBirth(String years) {
        registerPage.DateOfBirthYear(years);
    }
    @And("User Enters email Address {string}")
    public void userEntersEmailAddress(String Email) {
        registerPage.EnterOfEmail(Email);
    }
    @And("User enters Password {string}")
    public void userEntersPassword(String Password) {
        registerPage.EnterPassword(Password);
    }
    @And("User enters confirm password {string}")
    public void userEntersConfirmPassword(String ConfirmPassword) {
        registerPage.EnterConfirmPassword(ConfirmPassword);
    }
    @And("User Clicks on Register Button")
    public void userClicksOnRegisterButton() {
        registerPage.RegisterButton();
    }
    @Then("User creates his account successfully")
    public void userCreatesHisAccountSuccessfully() {
        soft.assertEquals(registerPage.RegisterSuccessfully().isDisplayed(),true);
        String color = registerPage.RegisterSuccessfully().getCssValue("color");
        String expectedColor = "rgb(76, 177, 124)";
        soft.assertEquals(color, expectedColor, "The color does not match the expected value.");
        System.out.println("Your registration completed");
        soft.assertAll();
    }

}
