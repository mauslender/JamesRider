package app.jamesrider.pages;

import app.jamesrider.utils.WaitUtils;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginValidationPage extends BasePage {

    private By validationTitleLocation = By.id("com.hdw.james.rider:id/title");
    private By validationFirstNumberLocator = new AppiumBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"com.hdw.james.rider:id/inputEditText\").instance(0)");

    public LoginValidationPage(AppiumDriver driver) {
        super(driver);
    }

    public void enterValidationCode(String validationCode) {
        WaitUtils.waitForElementPresence(driver, validationTitleLocation, 5);
        WaitUtils.waitForElementToBeVisible(driver, validationFirstNumberLocator, 5);

        for (int i = 0; i < validationCode.length(); i++) {
            // Locate the input field using UiSelector and instance
            String selector = String.format("new UiSelector().resourceId(\"com.hdw.james.rider:id/inputEditText\").instance(%d)", i);
            WebElement inputField = driver.findElement(AppiumBy.androidUIAutomator(selector));

            // Enter the corresponding digit into the input field
            inputField.sendKeys(Character.toString(validationCode.charAt(i)));
        }
    }
}
