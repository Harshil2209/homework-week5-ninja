package com.tutorialninja.pages;

import com.tutorialninja.customlisteners.CustomListeners;
import com.tutorialninja.utility.Utility;

public class AccountPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//a[@title='My Account']")
    WebElement myAccountLink;

    @CacheLookup
    @FindBy(xpath = "//a[@class='btn btn-primary']")
    WebElement continueAfterLogout;

    @CacheLookup
    @FindBy(xpath = "//div[@id='content']/h2[text()='My Account']")
    WebElement myAccountText;

    public void selectMyAccountOption(String option) {
        List<WebElement> myAccountsList = driver.findElements(By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li"));
        try {
            for (WebElement options : myAccountsList) {
                if (options.getText().equalsIgnoreCase(option)) {
                    options.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            myAccountsList = driver.findElements(By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li"));
        }
    }

    public void clickOnMyAccountLink() {
        Reporter.log("Clicking on my account Button " + myAccountLink.toString());
        clickOnElement(myAccountLink);
        CustomListeners.test.log(Status.PASS, "Click on account button");
    }

    public void clickOnContinueAfterLogout() {
        Reporter.log("Clicking on my continue after Button " + continueAfterLogout.toString());
        clickOnElement(continueAfterLogout);
        CustomListeners.test.log(Status.PASS, "Click on continue after button");
    }

    public String getMyAccountText() {
        Reporter.log("Getting my account text " + myAccountText.toString());
        CustomListeners.test.log(Status.PASS, "Get my account text");
        return getTextFromElement(myAccountText);
    }

}
