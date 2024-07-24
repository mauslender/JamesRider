package app.jamesrider.pages;

import app.jamesrider.utils.WaitUtils;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "com.hdw.james.rider:id/spinner")
    private WebElement countryCodeDropdown;
    private By loginTitleLocator = By.id("com.hdw.james.rider:id/title");
    private By phoneNumberFieldLocator = By.id("com.hdw.james.rider:id/input");

    public LoginPage(AppiumDriver driver) {
        super(driver);
    }

    public boolean assertLoginTitleIsDisplayed() {
        WaitUtils.waitForElementPresence(driver, loginTitleLocator, 7);

        WebElement loginTitle = driver.findElement(loginTitleLocator);
        return loginTitle.isDisplayed();
    }

    public void clickCountryCodeDropdown() {
        countryCodeDropdown.click();
    }

    public void clickOnCountryCode(String countryName) {

        // Scroll to the top of the spinner
        String scrollToTopSelector = "new UiScrollable(new UiSelector().scrollable(true)).scrollToBeginning(10);";
        driver.findElement(AppiumBy.androidUIAutomator(scrollToTopSelector));

        // Scroll to the desired Country code
        String scrollableSelector = String.format("new UiScrollable(new UiSelector()).scrollIntoView(text(\"%s\"));", countryName);
        By countryCodeToSelect = new AppiumBy.ByAndroidUIAutomator(scrollableSelector);

        WaitUtils.waitForElementToBeVisible(driver, countryCodeToSelect, 3);
        WaitUtils.waitForElementToBeClickable(driver, countryCodeToSelect, 3);

        // Click the desired Country code
        driver.findElement(countryCodeToSelect).click();
    }

    public void enterPhoneNumber(String phoneNumber) {
        WaitUtils.waitForElementPresence(driver, phoneNumberFieldLocator, 5);

        driver.findElement(phoneNumberFieldLocator).sendKeys(phoneNumber);
    }

}
