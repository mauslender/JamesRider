package app.jamesrider.pages;

import app.jamesrider.utils.WaitUtils;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected AppiumDriver driver;

    private By continueButtonLocator = By.id("com.hdw.james.rider:id/continueButton");

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickContinueButton() {
        WaitUtils.waitForElementToBeClickable(driver, continueButtonLocator, 5);

        driver.findElement(continueButtonLocator).click();
    }
}

