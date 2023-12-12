package com.tutorialninja.pages;

import com.tutorialninja.customlisteners.CustomListeners;
import com.tutorialninja.utility.Utility;
import jdk.javadoc.doclet.Reporter;

public class AccountCreationPage extends Utility {
    @CacheLoohup
    @FindBy(xpath = "//div[@id='content']/h1")
    WebElement accountCreationText;
    @CacheLookup
    @FindBy(xpath = "//a[text()='Continue']")
    WebElement continueAfterAccountCreation;


    public String getAccountCreationMessage() {
        Reporter.log("Getting account creation text " + accountCreationText.toString());
        CustomListeners.test.log(Status.PASS, "Get account creation text");
        return getTextFromElement(accountCreationText);
    }

    public void clickOnContinueAfterAccountCreation() {
        Reporter.log("Clicking on continue after account button " + continueAfterAccountCreation.toString());
        clickOnElement(continueAfterAccountCreation);
        CustomListeners.test.log(Status.PASS, "Click on continue after account button");
    }
}
