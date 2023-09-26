package Pages;

import StepsDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;



public class P01_RegisterPage {


    public void Male_Gender(){
        Hooks.driver.findElement(By.id("gender-male")).click();
    }
    public void Female_Gender(){
        Hooks.driver.findElement(By.id("gender-female")).click();
    }
    public void EnterFirstName(String  FirstName){
        Hooks.driver.findElement(By.id("FirstName")).sendKeys(FirstName);
    }
    public void EnterLastName(String Lastname){
        Hooks.driver.findElement(By.id("LastName")).sendKeys(Lastname);
    }
    public void DaysOfBirth(String Day){
        Select select= new Select(Hooks.driver.findElement(By.name("DateOfBirthDay")));
        select.selectByValue(Day);
    }
    public void MonthsOfBirth(String Months){
        Select select = new Select(Hooks.driver.findElement(By.name("DateOfBirthMonth")));
        select.selectByVisibleText(Months);
    }
    public void DateOfBirthYear(String Years){
        Select select = new Select(Hooks.driver.findElement(By.name("DateOfBirthYear")));
        select.selectByValue(Years);
    }
    public void EnterOfEmail(String  Email){
        Hooks.driver.findElement(By.id("Email")).sendKeys(Email);
    }
    public void EnterPassword(String  Password){
        Hooks.driver.findElement(By.id("Password")).sendKeys(Password);
    }
    public void EnterConfirmPassword(String ConfirmPassword){
        Hooks.driver.findElement(By.id("ConfirmPassword")).sendKeys(ConfirmPassword);
    }
    public void RegisterButton(){
        Hooks.driver.findElement(By.id("register-button")).click();
    }
    public WebElement RegisterSuccessfully(){
        return Hooks.driver.findElement(By.className("result"));
    }

}
