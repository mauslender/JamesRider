package app.jamesrider.pages;

import app.jamesrider.utils.WaitUtils;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class LoginPermissionsPage extends BasePage{

    private By locationPermissionButtonLocator = By.id("com.hdw.james.rider:id/permissionsLocationButton");
    private By locationConfirmationPermissionButtonLocator = By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button");
    private By notificationsPermissionButtonLocator = By.id("com.hdw.james.rider:id/permissionsNotificationButton");
    private By notificationsConfirmationPermissionButtonLocator = By.id("com.android.permissioncontroller:id/permission_allow_button");
    private By permissionsPageTitleLocator = By.id("com.hdw.james.rider:id/permissionsTextTitle");
    private By continueButton = By.id("com.hdw.james.rider:id/permissionsContinueButton");;

    public LoginPermissionsPage(AppiumDriver driver) {
        super(driver);
    }

    public boolean assertPermissionsPageIsDisplayed() {
        WaitUtils.waitForElementPresence(driver, permissionsPageTitleLocator, 5);

        boolean elementIsDisplayed;
        elementIsDisplayed = driver.findElement(permissionsPageTitleLocator).isDisplayed();
        return elementIsDisplayed;
    }

    public void clickLocationPermissionButton() {
        WaitUtils.waitForElementToBeClickable(driver, locationPermissionButtonLocator, 5);

        driver.findElement(locationPermissionButtonLocator).click();

        //Confirmation of allowing Location
        WaitUtils.waitForElementPresence(driver, locationConfirmationPermissionButtonLocator, 5);

        driver.findElement(locationConfirmationPermissionButtonLocator).click();
    }

    public void clickNotificationsPermissionButton() {
        WaitUtils.waitForElementToBeClickable(driver, notificationsPermissionButtonLocator, 5);

        driver.findElement(notificationsPermissionButtonLocator).click();

        //Confirmation of allowing Notifications
        WaitUtils.waitForElementPresence(driver, notificationsConfirmationPermissionButtonLocator, 5);

        driver.findElement(notificationsConfirmationPermissionButtonLocator).click();
    }

    public void clickContinueButton() {
        WaitUtils.waitForElementToBeClickable(driver, continueButton, 5);

        driver.findElement(continueButton).click();
    }
}
