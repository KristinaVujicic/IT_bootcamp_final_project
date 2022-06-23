package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BasicTest {

    @Test(priority = 1)
    public void visitsTheLoginPage() {

        navPage.getChangeLanguageButton().click();
        navPage.getENGButtonFromDropdown().click();
        navPage.getLoginButton().click();

        Assert.assertTrue(driver.getCurrentUrl().contains("login"),
                "[ERROR] Page url does not contain /login");
    }

    @Test(priority = 2)
    public void checksInputTypes() {

        navPage.getLoginButton().click();

        Assert.assertEquals(loginPage.getEmail().getAttribute("type"), ("email"),
                "[ERROR] Attribute type does not contains email");

        Assert.assertEquals(loginPage.getPassword().getAttribute("type"), ("password"),
                "[ERROR] Attribute type does not contains password");

    }

    @Test(priority = 3)
    public void displaysErrorsWhenUserDoesNotExist() {

        navPage.getLoginButton().click();

        loginPage.getEmail().click();
        loginPage.getEmail().sendKeys("non-existing-user@gmal.com");

        loginPage.getPassword().click();
        loginPage.getPassword().sendKeys("password123");

        loginPage.getLogInButtonOnLogInPage().click();

        messagePopUpPage.waitForPopUpToBeVisible();

        Assert.assertEquals(messagePopUpPage.getElementsWithVisibleMessages().getText(),
                "User does not exists",
                "[ERROR] There is no error message displayed on this page!");

    }

    @Test(priority = 4)
    public void displaysErrorsWhenPasswordIsWrong() {

        navPage.getLoginButton().click();

        loginPage.getEmail().click();
        loginPage.getEmail().sendKeys("admin@admin.com");

        loginPage.getPassword().click();
        loginPage.getPassword().sendKeys("password123");

        loginPage.getLogInButtonOnLogInPage().click();

        messagePopUpPage.waitForPopUpToBeVisible();

        Assert.assertEquals(messagePopUpPage.getElementsWithVisibleMessages().getText(),
                "Wrong password",
                "[ERROR] There is no error message displayed on this page!");

        Assert.assertTrue(driver.getCurrentUrl().contains("login"),
                "[ERROR] Page url does not contain /login");

    }

    @Test(priority = 5)
    public void validLogin() {

        navPage.getLoginButton().click();

        loginPage.getEmail().click();
        loginPage.getEmail().sendKeys("admin@admin.com");

        loginPage.getPassword().click();
        loginPage.getPassword().sendKeys("12345");

        loginPage.getLogInButtonOnLogInPage().click();


        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "[ERROR] Page url does not contain /login");

    }

    @Test(priority = 6)
    public void logout() {


        Assert.assertTrue(navPage.getLogOutButton().isDisplayed(),
                "[ERROR] This element is not visible");

        navPage.getLogOutButton().click();


    }

}
