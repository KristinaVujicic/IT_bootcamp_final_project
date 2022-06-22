package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CitiesPage {

    private WebDriver driver;

    public CitiesPage (WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getNewItemButton () {
        return driver.findElement(By.xpath("// button [contains (@class, 'btnNewItem ')]"));
    }

    public void waitForEditiPopUpToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By
                .xpath("// div [contains (@class, 'dlgNewEditItem ')]")));

    }

    public WebElement getNewItemInput(){
        return driver.findElement(By.xpath("// input [@id= 'name']"));
    }

    public WebElement getSaveButton () {
        return driver.findElement(By.xpath("//button[contains(@class, 'btnSave')]"));
    }


    public void waitForSuccessPopUpToBeVisible(){
       WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
       wait.until(ExpectedConditions.visibilityOfElementLocated(By
               .xpath("//div[contains(text(),'Saved successfully')]")));
    }

    public void waitForDeletePopUpToBeVisible(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath("//div[contains(text(),' Deleted successfully ')]")));
    }

    public WebElement getMessageTextFromSuccesPopUp() {
        return driver.findElement(By.xpath("// div [contains (@class, 'success')]"));
    }

    public WebElement getSearchInout () {

        return driver.findElement(By.id("search"));
    }

    public void waitForNumbersOfRowsToBe (int rowIndex) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.tagName("tr"), rowIndex +1 ));
    }

    public WebElement getTableCellFromRow (int rowIndex, int cellIndex){
        return driver
                .findElement(By.xpath("//table/tbody/tr[" + rowIndex + "]/td[" + cellIndex + "]"));
    }

    public WebElement getEditButtonFromRow (int row){
        return driver.findElement(By.xpath("//tbody/tr[" + row + "]/td/div/button[@id = 'edit']"));
    }

    public WebElement getDeleteButtonFromRow (int row){
        return driver.findElement(By.xpath("//tbody/tr[" + row + "]/td/div/button[@id = 'delete']"));
    }

    public void waitForDeletePopUpToBeVisable(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(
                        By.xpath("//*[text() = 'Do you really want to delete this item?']")));
    }

    public WebElement getDeleteButtonInDeletePopUp(){
        return driver.findElement(By.xpath("//span[contains(text(), ' Delete')]"));
    }















}
