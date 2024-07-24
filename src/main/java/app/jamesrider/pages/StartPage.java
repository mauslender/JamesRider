package app.jamesrider.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartPage extends BasePage {

    @FindBy(id = "com.hdw.james.rider:id/getStartedButton")
    private WebElement getStartedButton;
    public StartPage(AppiumDriver driver) {
        super(driver);
    }

    public boolean assertGetStartedButtonIsDisplayed() {
        boolean elementIsDisplayed;
        elementIsDisplayed = getStartedButton.isDisplayed();
        return elementIsDisplayed;
    }
    public void clickGetStartedButton() {
        getStartedButton.click();
    }
}
