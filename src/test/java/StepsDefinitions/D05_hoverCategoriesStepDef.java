package StepsDefinitions;

import Pages.P03_HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class D05_hoverCategoriesStepDef {
    P03_HomePage homePage=new P03_HomePage();
    @Given("User go to home Page and click on menu")
    public void MenuBar(){
        homePage.MenuBar();
    }
    @When("User hover over Computer")
    public void userHoverOverComputer() throws InterruptedException {
        homePage.HoverOver();
    }
    @And("User  choose desktop tab")
    public void userChooseDesktop() {
        homePage.SelectSubCategories();
    }
    @And("User Open desktop page")
    public void userOpenDesktopPage() {
        homePage.DesktopPage();
    }
    @Then("User Sure over them")
    public void userSureOverThem() throws InterruptedException {
        homePage.SureHovering();
    }

}
