package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavPage {

    private WebDriver driver;

    public NavPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getLoginButton() {
        return driver.findElement(By.xpath("// a [contains (@class, 'btnLogin')]"));
    }

    public WebElement getChangeLanguageButton() {
        return driver.findElement(By
                .xpath("// button [contains (@class, 'btnLocaleActivation v-btn v-btn--flat v-btn--text theme--light v-size--default')]"));

    }

    public WebElement getENGButtonFromDropdown() {
        return driver.findElement(By.xpath("// div [contains (@id, 'list-item-73')]"));
    }

    public WebElement getLogOutButton() {
        return driver.findElement(By.xpath("// button [contains (@class, 'btnLogout')]"));
    }

    public WebElement getSignUpButton() {
        return driver.findElement(By
                .xpath("// a [@href= '/signup']"));
    }

    public WebElement getAdminButton() {
        return driver.findElement(By.xpath("// button [contains (@class, 'btnAdmin')]"));

    }

    public WebElement getCityButton() {
        return driver.findElement(By.xpath("// a [contains (@class, 'btnAdminCities')]"));
    }

    public WebElement getUsersButton() {
        return driver.findElement(By.xpath("// a [contains (@class, 'btnAdminUsers')]"));
    }

    public WebElement getLanguageButton() {
        return this.driver.findElement(By.xpath("//button[contains(@class, 'btnLocaleActivation')]"));
    }

    public WebElement getLanguageESButton() {
        return this.driver.findElement(By.xpath("//div[contains(@class, 'btnES')]"));
    }

    public WebElement getLanguageFRButton() {
        return this.driver.findElement(By.xpath("//div[contains(@class, 'btnFR')]"));
    }

    public WebElement getLanguageCNButton() {
        return this.driver.findElement(By.xpath("//div[contains(@class, 'btnCN')]"));
    }

    public WebElement getHeader() {
        return driver.findElement(By.tagName("h1"));
    }

    public WebElement getHomeButton() {
        return driver.findElement(By
                .xpath("//a [@class= 'v-btn--active v-btn v-btn--flat v-btn--router v-btn--text theme--light v-size--default hidden-sm-and-down']"));
    }


}
