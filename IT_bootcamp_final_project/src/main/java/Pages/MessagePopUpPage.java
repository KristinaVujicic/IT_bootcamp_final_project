package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class MessagePopUpPage {

    private WebDriver driver;

    public MessagePopUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForPopUpToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By
                .xpath("// div [contains (@class, 'v-snack__content')]")));

    }

    public WebElement getElementsWithVisibleMessages() {
        return driver.findElement(By
                .xpath("//div[contains(@class, 'container')]/div/div/div/div/div/div/div/ul/li"));
    }

    public void waitForImportantPopUpToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By
                .xpath("// div [contains (@class, 'dlgVerifyAccount')]")));

    }

    public WebElement getImportantElementsWithVisibleMessages() {
        return driver.findElement(By
                .xpath("// div [contains (@class, 'dlgVerifyAccount')]"));
    }

    public WebElement getCloseImportantButton () {
        return driver.findElement(By.xpath("// button [contains (@class, 'btnClose ')]"));
    }

}
