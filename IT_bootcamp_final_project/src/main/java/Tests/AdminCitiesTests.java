package Tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BasicTest {


    @Test (priority = 1)
    public void visitsTheAdminCitiesPageAndListCities () throws InterruptedException {

        navPage.getLoginButton().click();
        loginPage.getEmail().click();
        loginPage.getEmail().sendKeys("admin@admin.com");

        loginPage.getPassword().click();
        loginPage.getPassword().sendKeys("12345");

        loginPage.getLogInButtonOnLogInPage().click();

        navPage.getAdminButton().click();
        Thread.sleep(1000);

        navPage.getCityButton().click();

        Assert.assertTrue(driver.getCurrentUrl().contains("/admin/cities"),
                "[ERROR] Page url does not contain /admin/cities");

    }

    @Test (priority = 2 )
    public void checksInputTypesForCreateOrEditNewCity ()  {


        navPage.getAdminButton().click();

        navPage.getCityButton().click();

        citiesPage.getNewItemButton().click();

        citiesPage.waitForEditiPopUpToBeVisible();

        Assert.assertEquals(citiesPage.getNewItemInput().getAttribute("type"),
                "text",
                "[ERROR] New item input 'type' attribute is not 'text'");

    }

    @Test (priority = 3)
    public void createNewCity () {

        navPage.getAdminButton().click();
        navPage.getCityButton().click();

        citiesPage.getNewItemButton().click();
        citiesPage.waitForEditiPopUpToBeVisible();

        citiesPage.getNewItemInput().sendKeys("KrisVuj's");
        citiesPage.getSaveButton().click();

        citiesPage.waitForSuccessPopUpToBeVisible();

        Assert.assertTrue(citiesPage.getMessageTextFromSuccesPopUp().getText().contains("Saved successfully"));

    }

    @Test (priority = 4)
    public void editCity () {

        navPage.getAdminButton().click();
        navPage.getCityButton().click();

        citiesPage.getSearchInout().sendKeys("KrisVuj's");
        citiesPage.waitForNumbersOfRowsToBe(1);
        citiesPage.getEditButtonFromRow(1).click();
        citiesPage.getNewItemInput().click();

        new Actions(driver)
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .sendKeys(Keys.BACK_SPACE)
                .perform();

        citiesPage.getNewItemInput().sendKeys("");
        citiesPage.getNewItemInput().sendKeys("VujKris's");
        citiesPage.getSaveButton().click();



        citiesPage.waitForSuccessPopUpToBeVisible();
        Assert.assertTrue(citiesPage.getMessageTextFromSuccesPopUp().getText().contains("Saved successfully"),
                "[ERROR] The message from pop-up should be 'Saved successfully'" );

    }

    @Test (priority = 5)
    public void searchCity () {

        navPage.getAdminButton().click();
        navPage.getCityButton().click();
        citiesPage.getSearchInout().sendKeys("VujKris's");
        citiesPage.waitForNumbersOfRowsToBe(1);

        Assert.assertTrue(citiesPage.getTableCellFromRow(1,2).getText().contains("VujKris's"),
                "[ERROR] The 'Name' column does not contain expected result");

    }

    @Test (priority = 6)
    public void deleteCity () {

        navPage.getAdminButton().click();
        navPage.getCityButton().click();

        citiesPage.getSearchInout().sendKeys("VujKris's");
        citiesPage.waitForNumbersOfRowsToBe(1);

        citiesPage.getDeleteButtonFromRow(1).click();
        citiesPage.waitForDeletePopUpToBeVisable();
        citiesPage.getDeleteButtonInDeletePopUp().click();

        citiesPage.waitForDeletePopUpToBeVisible();

        messagePopUpPage.waitForPopUpDeleteCityToBeVisible();

        Assert.assertTrue(messagePopUpPage.getElementsWithVisibleMessagesForCities().getText().contains("Deleted"),
                "[ERROR] City is not deleted");
    }










}



