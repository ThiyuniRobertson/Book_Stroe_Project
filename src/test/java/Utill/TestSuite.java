package Utill;

import frontEnd.AddToCart;
import frontEnd.BookView;
import frontEnd.Login;
import frontEnd.Register;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.ExtentReports;

import java.time.Duration;

public class TestSuite {

    protected static WebDriver driver;

    ExtentReports extent =new ExtentReports();
    ExtentSparkReporter spark =new ExtentSparkReporter("report/Spark.html");

   @BeforeMethod
    public void beforeMethod(){
       //Edge driver setuo
       WebDriverManager.edgedriver().setup();
       driver = new EdgeDriver();
       driver.manage().window().maximize();

       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       driver.get("https://www.automationstudy.site/classes/Login.php");
   }

   @BeforeTest
   public void beforeTest(){
      spark.config().setTheme(Theme.DARK);
      spark.config().setDocumentTitle("MyReport");
   }

   @Test(priority = 1)
   public void register() throws InterruptedException{
      Register registerPage = new Register(driver);
      registerPage.pageLoard();

      Register registerForm = new Register(driver);
      registerForm.userRegister();

      Login logingpage = new Login(driver);
      logingpage.userLogin("thiunirobertson@gmail.com","TS@0129r");

      BookView userView = new BookView(driver);
      userView.opeanBook();

      AddToCart cart = new AddToCart(driver);
      cart.bookCart();
   }

   @Test(priority = 2)
   public void systemLog(){
      ExtentTest test = extent.createTest("verify the pagetitle").assignAuthor("Siyathma").
              assignCategory("Functional Testing").assignDevice("Windows");
      test.info("I'am capturing the page title");

      String pagetitle = driver.getTitle();
      if(pagetitle.equals("Online Book Shop")){
         test.pass("Page title is verify" + pagetitle);
      }else{
         test.fail("Page title in not verify: " + pagetitle);
      }
   }

   @AfterTest
   public void afterTest(){
      extent.attachReporter(spark);
      extent.flush();
   }


   @AfterMethod
    public void afterMethod(){
        driver.quit();
   }


}
