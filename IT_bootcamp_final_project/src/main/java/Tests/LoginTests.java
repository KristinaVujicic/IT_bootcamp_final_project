package Tests;

import Pages.LoginPage;
import Pages.NavPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BasicTest {

    @Test (priority = 10)
    public void visitsTheLoginPage() throws InterruptedException {

        navPage.getChangeLanguageButton().click();
        navPage.getENGButtonFromDropdown().click();
        navPage.getLoginButton().click();
        Thread.sleep(1000);
        Assert.assertTrue(driver.getCurrentUrl().contains("login"),
                "[ERROR] Page url does not contain /login");
    }

}
