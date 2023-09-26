package Pages;

import StepsDefinitions.Hooks;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.testng.AssertJUnit.assertTrue;


public class P03_HomePage {
    Actions actions=new Actions(Hooks.driver);

    //register page
    public void ClickOnRegisterTab() {
        Hooks.driver.findElement(By.className("ico-register")).click();
    }


    //login page
    public void LoginTab() {
        Hooks.driver.findElement(By.className("ico-login")).click();
    }

    public WebElement MyAccount() {
        return Hooks.driver.findElement(By.className("ico-account"));
    }


    // Currencies
    public void SelectCurrencies() {
        Hooks.driver.findElement(By.id("customerCurrency")).click();
    }

    public void SelectEuroCurrency() {
        WebElement dropdownList = Hooks.driver.findElement(By.id("customerCurrency"));
        Select dropdown = new Select(dropdownList);
        dropdown.selectByVisibleText("Euro");
    }

    public void FourProduct() {
        List<WebElement> Products = Hooks.driver.findElements(By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[4]"));
        System.out.println(Products.size());
        for (WebElement product : Products) {
            Assert.assertFalse(product.getText().contains("Euro"));
        }
    }

    public void testCurrencyForItems() {
        List<WebElement> elements = Hooks.driver.findElements(By.xpath("//span[@class=\"price actual-price\"]"));
        for (WebElement element : elements) {
            String text = element.getText();
            Assert.assertTrue(text.contains("€"), "Text does not contain €");
        }
    }


    //Search page
    public void SearchBar(){
        Hooks.driver.findElement(By.id("small-search-box-form")).click();
    }

    public void EnterSearchWord(String search){
        Hooks.driver.findElement(By.id("small-searchterms")).sendKeys(search);
    }

    public void ClickSearchBar(){
        Hooks.driver.findElement(By.xpath("//*[@id=\"small-search-box-form\"]/button")).click();
    }

    public void ListOfItems(String ignoredExample){
        String searchWord = "Book";
        String SecondWord = "Laptop";
        String ThirdWord = "Nike";
        List<WebElement> elements = Hooks.driver.findElements(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div[2]/div/div[2]"));
        List<String> results = new ArrayList<>();
        for (WebElement element : elements) {
            results.add(element.getText());
        }
        for (int i = 0; i < results.size(); i++) {
            if (results.get(i).toLowerCase().contains(searchWord.toLowerCase())) {
                System.out.println("Result " + (i + 1) + " Contains Book");}
             if(results.get(i).toLowerCase().contains(SecondWord.toLowerCase())){
                System.out.println("Result " + (i + 1) + " contains Laptop");
             }
             else if (results.get(i).toLowerCase().contains(ThirdWord.toLowerCase())){
                    System.out.println("Result " + (i + 1) + " contains nike");
             }
            else {System.out.println("Result " + (i + 1) + " don't contain items");

             }
            }
    }

    public void ClickOnItem(){
        Hooks.driver.findElement(By.xpath("//div[@class=\"details\"]//h2[@class=\"product-title\"]//a")).click();
    }

    public void ContainSku(){
        Hooks.driver.findElement(By.className("sku")).isDisplayed();
        System.out.println("sku");
    }


    //Hover

    public void MenuBar(){
        Hooks.driver.findElement(By.xpath("//div[@class=\"header-menu\"]//ul[@class=\"top-menu notmobile\"]")).getLocation();
    }

    public void HoverOver(){
        // Find the element to hover over
        WebElement element = Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[1]"));

        // Create a new Actions instance
        Actions actions = new Actions(Hooks.driver);

        // Perform the mouse hover action
        actions.moveToElement(element).perform();
    }

    public void SelectSubCategories(){
       WebElement element = Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[1]"));
       WebElement subElement = Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[1]/ul/li[1]/a"));
       Actions actions = new Actions(Hooks.driver);
       actions.moveToElement(element).perform();
       actions.moveToElement(subElement).perform();
   }

    public void DesktopPage() {
        WebElement element = Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[1]"));
        WebElement subElement = Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[1]/ul/li[1]/a"));
        Actions actions = new Actions(Hooks.driver);
        actions.moveToElement(element).perform();
        actions.moveToElement(subElement).perform();
        subElement.click();

    }

     public void SureHovering() throws InterruptedException {
        Thread.sleep(5000);
        // Find the category element
        WebElement category = Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]"));

        // Check if the category has sub-categories
        List<WebElement> subCategories = category.findElements(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[3]/a"));
        if (subCategories.size() > 0) {
            // If there are sub-categories, click on a random one
            WebElement randomSubCategory = subCategories.get(new Random().nextInt(subCategories.size()));
            String expectedTitle = randomSubCategory.getText().toLowerCase().trim();
            randomSubCategory.click();

            // Get the title of the opened page
            String actualTitle = Hooks.driver.getTitle().toLowerCase().trim();

            // Assert that the opened page title contains the sub-category name
            Assert.assertTrue(actualTitle.contains(expectedTitle), "The page title does not contain the sub-category name.");
        } else {
            // If there are no sub-categories, click on the main category itself
            category.click();

            // Assert that the opened page contains the main category name
            assert Hooks.driver.getPageSource().contains(category.getText());
        }
    }


    //Home Slider
    public void Sliders(){
        Hooks.driver.findElement(By.id("nivo-slider"));
    }
    public void clickProductPage1(){

        WebElement movingImageSlide = Hooks.driver.findElement(By.xpath("//a[@class=\"nivo-control active\" and @rel=\"0\"]"));
        actions.moveToElement(movingImageSlide).perform();
        actions.click();
    }
    public String GotoLinkProduct(){
        WebDriverWait wait = new WebDriverWait(Hooks.driver,Duration.ofSeconds(30));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class=\"nivo-control active\" and @rel=\"0\"]")));
        return String.valueOf(element);

    }
    public void clickProductPage2() {
        WebDriverWait wait = new WebDriverWait(Hooks.driver,Duration.ofSeconds(5));
          WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class=\"nivo-control active\" and @rel=\"1\"]")));
        actions.moveToElement(element).perform();
        actions.click();
    }
    public String GoToUrl(){
        WebDriverWait wait = new WebDriverWait(Hooks.driver,Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class=\"nivo-control active\" and @rel=\"1\"]")));
        return String.valueOf(element);
    }

    //Follow us
    public void OpensFacebookHome(){
        Hooks.driver.findElement(By.cssSelector("a[href=\"http://www.facebook.com/nopCommerce\"]")).click();
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
    }

    public void RealFaceBookPAge(){
        ArrayList<String> tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
        System.out.println(tabs.size());
        Hooks.driver.switchTo().window(tabs.get(1));
        System.out.println("tab 1:  " +Hooks.driver.getCurrentUrl());
        Hooks.driver.switchTo().window(tabs.get(0));
        System.out.println("tab 0:  " + Hooks.driver.getCurrentUrl());
        Hooks.driver.close();
    }

    public void OpenTwitterFromHome(){
        Hooks.driver.findElement(By.cssSelector("a[href=\"https://twitter.com/nopCommerce\"]")).click();
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
    }

    public void RealTwitterPage(){
        ArrayList<String> tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
        System.out.println(tabs.size());
        Hooks.driver.switchTo().window(tabs.get(1));
        System.out.println("tab 1:  " +Hooks.driver.getCurrentUrl());
        Hooks.driver.switchTo().window(tabs.get(0));
        System.out.println("tab 0:  " + Hooks.driver.getCurrentUrl());
        Hooks.driver.close();
    }

    public void OpenRssHome(){
        Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[4]/div[1]/div[4]/div[1]/ul/li[3]/a")).click();
    }

    public void RealRssPage(){
        ArrayList<String> tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
        System.out.println(tabs.size());
        Hooks.driver.switchTo().window(tabs.get(1));
        System.out.println("tab 1:  " +Hooks.driver.getCurrentUrl());
        Hooks.driver.switchTo().window(tabs.get(0));
        System.out.println("tab 0:  " + Hooks.driver.getCurrentUrl());
        Hooks.driver.close();
    }

    public void OpenYoutubeFromHome(){
        Hooks.driver.findElement(By.cssSelector("a[href=\"http://www.youtube.com/user/nopCommerce\"]")).click();
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
    }

    public void RealYoutubePage(){
        ArrayList<String> tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
        System.out.println(tabs.size());
        Hooks.driver.switchTo().window(tabs.get(1));
        System.out.println("tab 1:  " +Hooks.driver.getCurrentUrl());
        Hooks.driver.switchTo().window(tabs.get(0));
        System.out.println("tab 0:  " + Hooks.driver.getCurrentUrl());
        Hooks.driver.close();
    }


    //Wishlist

    public void FindProducts(){
        Hooks.driver.findElement(By.xpath("//div[@class=\"product-grid home-page-product-grid\"]//div[@class=\"item-grid\"]")).getLocation();
    }

    public void ClickOnWishList()  {

        Hooks.driver.findElements(By.cssSelector(".button-2.add-to-wishlist-button")).get(2).click();

    }

    public String WishlistSuccess() {
// Wait for the toast to appear
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10).plusMillis(500));
        return  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("success"))).getCssValue("background-color");

    }
    public String rgbToHex(String rgbColor) {
        // Remove "rgb(" and ")" and split into RGB components
        String[] rgbParts = rgbColor.replace("rgb(", "").replace(")", "").split(",");

        int r = Integer.parseInt(rgbParts[0].trim());
        int g = Integer.parseInt(rgbParts[1].trim());
        int b = Integer.parseInt(rgbParts[2].trim());

        // Convert RGB to Hex
        return String.format("#%02x%02x%02x", r, g, b);
    }

    public void WaitWishlist() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        WebElement successBar = Hooks.driver.findElement(By.xpath("//*[@id=\"bar-notification\"]"));
        wait.until(ExpectedConditions.invisibilityOf(successBar));
        Thread.sleep(5000);
    }

    public void GotoWishlist(){
        WebElement element = Hooks.driver.findElement(By.className("ico-wishlist"));
        ((JavascriptExecutor) Hooks.driver).executeScript("arguments[0].scrollIntoView();", element);
        Hooks.driver.findElement(By.xpath("//div[@class=\"header-links\"]//ul//li//a[@href=\"/wishlist\"]")).click();
    }

    public void AssertQuantity() throws InterruptedException {
        Thread.sleep(2000);
// Find the Qty element
        WebElement qtyElement = Hooks.driver.findElement(By.className("qty-input")); // Replace By.id("qty") with the appropriate locator for your Qty element
// Get the Qty value as a String
        String qtyString = qtyElement.getAttribute("value"); // Replace getText() with getAttribute(attributeName) or getCssValue(propertyName) if necessary
// Convert the Qty value to an int
        int qty = Integer.parseInt(qtyString);
// Assert that the Qty value is greater than 0
        assertTrue("Qty should be greater than 0", qty>0);

    }

}


