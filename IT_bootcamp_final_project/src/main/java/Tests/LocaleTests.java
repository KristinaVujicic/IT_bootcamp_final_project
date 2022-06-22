package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BasicTest{

    @Test (priority = 1)
    public void setLocaleToES () {

            navPage.getLanguageButton().click();
            navPage.getLanguageESButton().click();

            Assert.assertTrue(navPage.getHeader().getText()
                            .contains("Página de aterrizaje"),
                    "[ERROR] Header does not contain 'Página de aterrizaje' text");

    }
    @Test (priority = 2)
    public void setLocaleToEN () {

        navPage.getLanguageButton().click();
        navPage.getENGButtonFromDropdown().click();

        Assert.assertTrue(navPage.getHeader().getText()
                        .contains("Landing"),
                "[ERROR] Header does not contain 'Landing' text");

    }

    @Test (priority = 3)
    public void setLocaleToCN () {

        navPage.getLanguageButton().click();
        navPage.getLanguageCNButton().click();

        Assert.assertTrue(navPage.getHeader().getText()
                        .contains("首页"),
                "[ERROR] Header does not contain '首页' text");

    }

    @Test (priority = 4)
    public void setLocaleToFR () {

        navPage.getLanguageButton().click();
        navPage.getLanguageFRButton().click();

        Assert.assertTrue(navPage.getHeader().getText()
                        .contains("Page d'atterrissage"),
                "[ERROR] Header does not contain 'Page d'atterrissage' text");

    }

}

