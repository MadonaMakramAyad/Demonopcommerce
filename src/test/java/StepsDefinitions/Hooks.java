package StepsDefinitions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Hooks {
    public static WebDriver driver;
    @Before
    public static void OpenBrowser() {
        driver=new FirefoxDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.nopcommerce.com/");
    }

    @After
    public static void CloseBrowser() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
