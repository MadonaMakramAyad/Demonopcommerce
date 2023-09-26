package StepsDefinitions;

import Pages.P03_HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.asserts.SoftAssert;

public class D03_CurrenciesStepDefs {
    P03_HomePage homePage = new P03_HomePage();
    SoftAssert soft =new SoftAssert();
    @Given("User got to Currencies Categories")
    public void CurrenciesCategories(){
        homePage.SelectCurrencies();
    }
    @And("User Select from Currencies")
    public void userSelectFromCurrencies() {
        homePage.SelectEuroCurrency();
    }
    @And("User finds four Products with Euro currencies")
    public void userFindsFourProductsWithEuroCurrencies() {
        homePage.FourProduct();
    }
    @Then("User Checks that all products contains Euro sign")
    public void userChecksThatAllProductsContains_Euro_Sign() {
        homePage.testCurrencyForItems();
    }

}
