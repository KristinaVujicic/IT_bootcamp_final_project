package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTests extends BasicTest{

    @Test (priority = 1)
    public void visitsTheSignupPage () throws InterruptedException {

        navPage.getSignUpButton().click();

        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"),
                "[ERROR] Page url does not contain /signup");

    }

    @Test (priority = 2)
    public void checksInputTypes (){

        navPage.getSignUpButton().click();
        Assert.assertEquals(signUpPage.getEmailInput().getAttribute("type"), ("email"),
                "[ERROR] Attribute type does not contains email");

        Assert.assertEquals(signUpPage.getPasswordInput().getAttribute("type"), ("password"),
                "[ERROR] Attribute type does not contains password");

        Assert.assertEquals(signUpPage.getConfirmPassword().getAttribute("type"), ("password"),
                "[ERROR] Attribute type does not contains password");

    }

    @Test
    public void  displaysErrorsWhenUserAlreadyExists () {

        navPage.getSignUpButton().click();

        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"),
                "[ERROR] Page url does not contain /signup");

        signUpPage.getNameInput().sendKeys("Another User");
        signUpPage.getEmailInput().sendKeys("admin@admin.com");
        signUpPage.getPasswordInput().sendKeys("12345");
        signUpPage.getConfirmPassword().sendKeys("12345");

        signUpPage.getSignUpButton().click();

        messagePopUpPage.waitForPopUpToBeVisible();

        Assert.assertEquals(messagePopUpPage.getElementsWithVisibleMessages().getText(),
                "E-mail already exists",
                "[ERROR] There is no error message displayed on this page!");

        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"),
                "[ERROR] Page url does not contain /signup");

    }

    @Test (priority = 4)
    public void signup () throws InterruptedException {

        navPage.getSignUpButton().click();

        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"),
                "[ERROR] Page url does not contain /signup");

        signUpPage.getNameInput().sendKeys("Kristina Vujicic");
        signUpPage.getEmailInput().sendKeys("kristina.vujicic@itbootcamp.rs");
        signUpPage.getPasswordInput().sendKeys("12345");
        signUpPage.getConfirmPassword().sendKeys("12345");

        signUpPage.getSignUpButton().click();

        Thread.sleep(2000);

        messagePopUpPage.waitForImportantPopUpToBeVisible();

        Assert.assertEquals(messagePopUpPage.getImportantElementsWithVisibleMessages().getText(),
                "IMPORTANT: Verify your account",
                "[ERROR] There is no 'IMPORTANT: Verify your account message' displayed on this page!");

        messagePopUpPage.getCloseImportantButton().click();

        navPage.getLogOutButton().click();

    }


}
