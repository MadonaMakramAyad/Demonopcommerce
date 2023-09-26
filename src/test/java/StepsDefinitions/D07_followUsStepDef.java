package StepsDefinitions;

import Pages.P03_HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import java.util.Objects;

public class D07_followUsStepDef {
    P03_HomePage homePage=new P03_HomePage();
    @Given("user opens facebook link")
    public void OpensFacebookPage(){
        homePage.OpensFacebookHome();
    }
    @When("User clicks on exist button")
    public void userClicksOnExistButton() {
        homePage.RealFaceBookPAge();
    }
    @Then("facebook page is opened in new tab")
    public void facebookPageIsOpenedInNewTab() {
        assert Objects.equals(Hooks.driver.getCurrentUrl(), "https://www.facebook.com/nopCommerce");
        System.out.println("Feature passed");
    }
    @Given("user opens Twitter link")
    public void userOpensTwitterLink() {
        homePage.OpenTwitterFromHome();
    }

    @When("Twitter page is opened in new tab")
    public void twitterPageIsOpenedInNewTab() {
        homePage.RealTwitterPage();
    }
    @Then("User check for follow Page")
    public void userCheckForFollowPage() {
        assert Objects.equals(Hooks.driver.getCurrentUrl(), "https://twitter.com/nopCommerce");
        System.out.println("Feature passed");
    }
    @Given("user opens rss  link")
    public void userOpensRssLink() {
        homePage.OpenRssHome();
    }
    @When("rss page is opened in new tab")
    public void rssPageIsOpenedInNewTab() {
        homePage.RealRssPage();
    }
    @Then("User check for follow Page in rss Page")
    public void userCheckForFollowPageInRssPage() {
        assert Objects.equals(Hooks.driver.getCurrentUrl(), "https://demo.nopcommerce.com/new-online-store-is-open");
        System.out.println("Feature passed");
    }
    @Given("user opens youtube link")
    public void userOpensYoutubeLink() {
        homePage.OpenYoutubeFromHome();
    }
    @When("youtube page is opened in new tab")
    public void youtubePageIsOpenedInNewTab() {
        homePage.RealYoutubePage();
    }
    @Then("User check for follow Page in youtube")
    public void userCheckForFollowPageInYoutube() {
        assert Objects.equals(Hooks.driver.getCurrentUrl(), "http://www.youtube.com/user/nopCommerce");
        System.out.println("Feature passed");
    }
}
