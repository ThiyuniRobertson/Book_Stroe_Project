package frontEnd;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BookView {

    protected WebDriver driver;
//    By bookView = By.xpath("//div[@class ='container px-4 px-lg-5 mt-5']/div[1]/div[1]/div/div[2]/div/a[text() ='View']");
    By bookView = By.xpath("//section[@class ='py-5']/div/div/div[1]/div/div[2]/div/a[text() = 'View']");

    public BookView(WebDriver driver){

        this.driver = driver;
    }

    public void opeanBook(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));

        WebElement view = wait.until(ExpectedConditions.elementToBeClickable(bookView));
        view.click();

    }

}
