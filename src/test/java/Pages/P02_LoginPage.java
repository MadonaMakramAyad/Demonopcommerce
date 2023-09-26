package Pages;

import StepsDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P02_LoginPage {
    public void EnterEmailAddress(String EmailAddress){
        Hooks.driver.findElement(By.className("email")).sendKeys(EmailAddress);
    }
    public void EnterPassword(String Password){
        Hooks.driver.findElement(By.id("Password")).sendKeys(Password);
    }
    public void LoginButton(){
        Hooks.driver.findElement(By.xpath("//div[@class=\"buttons\"]//button[@type=\"submit\"]")).click();
    }
    public WebElement LoginFailed(){
        return Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[1]"));
    }
}
