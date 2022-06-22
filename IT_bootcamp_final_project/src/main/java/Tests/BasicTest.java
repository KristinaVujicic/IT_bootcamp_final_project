package Tests;


import Pages.LoginPage;
import Pages.MessagePopUpPage;
import Pages.NavPage;
import Pages.SignUpPage;
import Pages.CitiesPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public abstract class BasicTest {

    protected WebDriver driver;
    protected String baseUrl = "https://vue-demo.daniel-avellaneda.com/";
    protected LoginPage loginPage;
    protected NavPage navPage;

    protected MessagePopUpPage messagePopUpPage;

    protected SignUpPage signUpPage;

    protected CitiesPage citiesPage;

    protected WebDriverWait wait;


    @BeforeClass
    public void beforeClass () {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));


        loginPage = new LoginPage(driver);
        navPage = new NavPage(driver);
        messagePopUpPage = new MessagePopUpPage(driver);
        signUpPage = new SignUpPage(driver);
        citiesPage = new CitiesPage(driver);




    }

    @BeforeMethod
    public void beforeMethod () {
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod() {

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }


}
