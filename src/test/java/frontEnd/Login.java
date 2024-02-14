package frontEnd;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;

public class Login {

        protected WebDriver driver;

        public Login(WebDriver driver){
                this.driver = driver;
        }

        By loging = By.xpath("//button[@id='login-btn']");
        By email = By.xpath("//input[@type = 'email']");
        By pass = By.xpath("//input[@type = 'password']");
        By loginBtn = By.xpath("//button[@class = 'btn btn-primary btn-flat']");

        public void userLogin(String username, String password) throws InterruptedException{
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

                driver.findElement(loging).click();
                WebElement usernameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(email));
                usernameInput.sendKeys(username);

                WebElement userPass = wait.until(ExpectedConditions.visibilityOfElementLocated(pass));
                userPass.sendKeys(password);

                driver.findElement(loginBtn).click();
                String pageURL =driver.getCurrentUrl();
                assertEquals(pageURL, "https://www.automationstudy.site/");

                Thread.sleep(6000);

        }
}
