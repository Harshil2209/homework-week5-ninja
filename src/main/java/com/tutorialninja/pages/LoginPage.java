package com.tutorialninja.pages;

import com.tutorialninja.customlisteners.CustomListeners;
import com.tutorialninja.utility.Utility;

public class LoginPage extends Utility {
    @CacheLookup
    @FindBy(name = "email")
    WebElement email;
    @CacheLookup
    @FindBy(name = "password")
    WebElement password;
    @CacheLookup
    @FindBy(xpath = "//input[@value='Login']")
    WebElement loginButton;

    public void sendEmail(String inputEmail) {
        Reporter.log("Enter email" + inputEmail + "to  field " + email.toString());
        sendTextToElement(email, inputEmail);
        CustomListeners.test.log(Status.PASS, "Enter EmailId " + inputEmail);
    }

    public void sendPassword(String inputPassword) {
        Reporter.log("Enter password" + inputPassword + "to field " + password.toString());
        sendTextToElement(password, inputPassword);
        CustomListeners.test.log(Status.PASS, "Enter password " + inputPassword);
    }

    public void clickOnLogin() {
        Reporter.log("Clicking on Login Button " + loginButton.toString());
        clickOnElement(loginButton);
        CustomListeners.test.log(Status.PASS, "Click on loginButton");
    }
}
