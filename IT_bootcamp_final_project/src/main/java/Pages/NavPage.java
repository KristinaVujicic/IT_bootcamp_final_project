package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class NavPage {

    private WebDriver driver;

    public NavPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getLoginButton () {
        return driver.findElement(By.xpath("// a [contains (@class, 'btnLogin')]"));
    }

    public WebElement getChangeLanguageButton(){
        return driver.findElement(By
                .xpath("// button [contains (@class, 'btnLocaleActivation v-btn v-btn--flat v-btn--text theme--light v-size--default')]"));

    }
    public WebElement getENGButtonFromDropdown(){
        return driver.findElement(By.xpath("// div [contains (@id, 'list-item-73')]"));
    }



}
