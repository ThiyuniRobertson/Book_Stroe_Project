package frontEnd;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Register {

    protected WebDriver driver;

    By goBackLink = By.xpath("//a[text() ='Go Back.']");
    By logingBtn = By.xpath("//button[@id='login-btn']");
    By createAcount = By.xpath("//a[@id ='create_account']");

    By fname = By.xpath("//input[@name = 'firstname']");
    By lname = By.xpath("//input[@name = 'lastname']");
    By contact = By.xpath("//input[@name = 'contact']");
    By gender = By.xpath("//*[@name ='gender']");
    By address = By.xpath("//textarea[@name = 'default_delivery_address']");
    By emai = By.xpath("//input[@name = 'email']");
    By password = By.xpath("//input[@name = 'password']");
    By rebtn = By.xpath("//button[text() = 'Register']");

    public Register(WebDriver driver){
        this.driver = driver;
    }

    public void pageLoard(){
        // Using WebDriverWait instead of Thread.sleep()
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Wait for the "Go Back" link to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(goBackLink)).click();
    }

    public void userRegister(){
        //Click on login button
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.findElement(logingBtn).click();
        //Clcik on the create new account
        WebElement crateAccount = wait.until(ExpectedConditions.visibilityOfElementLocated(createAcount));
        crateAccount.click();

        WebElement registerForm = wait.until(ExpectedConditions.visibilityOfElementLocated(fname));
        registerForm.sendKeys("Thiyuni");
        driver.findElement(lname).sendKeys("Robertson");
        driver.findElement(contact).sendKeys("0112755258");
        Select dropdown = new Select(driver.findElement(gender));
        dropdown.selectByVisibleText("Female");
        driver.findElement(address).sendKeys("113/5/2,Homagama");
        driver.findElement(emai).sendKeys("test@gmail.com");
        driver.findElement(password).sendKeys("123456");

        driver.findElement(rebtn).click();
        driver.navigate().refresh();
    }
}
