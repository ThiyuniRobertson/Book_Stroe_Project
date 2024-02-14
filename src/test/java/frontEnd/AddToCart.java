package frontEnd;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddToCart {

    protected WebDriver driver;
    By cart = By.xpath("//form[@id = 'add-cart']/div/button");

    public AddToCart(WebDriver driver){

        this.driver = driver;
    }

    public void bookCart(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement userCart = wait.until(ExpectedConditions.elementToBeClickable(cart));
        userCart.click();
    }

}
