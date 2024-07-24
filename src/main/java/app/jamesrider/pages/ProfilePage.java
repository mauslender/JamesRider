package app.jamesrider.pages;

import app.jamesrider.utils.WaitUtils;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage {

    @FindBy(id = "com.hdw.james.rider:id/DEFAULT_TEXT_ACTION_MENU_ID")
    private WebElement doneButton;
    private By firstNameFieldLocator = By.id("com.hdw.james.rider:id/firstNameInput");
    private By lastNameFieldLocator = By.id("com.hdw.james.rider:id/lastNameInput");

    public ProfilePage(AppiumDriver driver) {
        super(driver);
    }

    public void enterFirstName(String firstName) {
        WaitUtils.waitForElementPresence(driver, firstNameFieldLocator, 5);

        driver.findElement(firstNameFieldLocator).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        WaitUtils.waitForElementPresence(driver, lastNameFieldLocator, 5);

        driver.findElement(lastNameFieldLocator).sendKeys(lastName);
    }

    public void clickDoneButton() { doneButton.click(); }
}
