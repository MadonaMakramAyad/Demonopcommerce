package StepsDefinitions;

import Pages.P03_HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class D04_SearchStepDefs {
        P03_HomePage homepage=new P03_HomePage();
        @Given("User go to home Page and Click on Search Bar")
        public void SearchForBookWord(){
            homepage.SearchBar();
        }
        @When("In the search Bar, User Search for {string}")
        public void inTheSearchBarUserSearchFor(String Item) {
            homepage.EnterSearchWord(Item);
        }
        @And("User Clicks on Search Bar")
        public void ClickSearchbar(){
            homepage.ClickSearchBar();
        }
       @Then("User go to List of {string}")
        public void userGoToListOf(String Examples) {
            homepage.ListOfItems(Examples);
       }
       @And("User clicks on each {string}")
       public void userClicksOnEach(String item) {
            homepage.ClickOnItem();
       }
       @Then("User verify existence for Sku")
       public void userVerifyExistenceForSku() {
            homepage.ContainSku();

       }
}
