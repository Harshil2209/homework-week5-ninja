package com.tutorialninja.pages;

import com.tutorialninja.customlisteners.CustomListeners;
import com.tutorialninja.utility.Utility;

public class LogOutPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Account Logout')]")
    WebElement logoutText;

    public String getTextFromLogout() {
        Reporter.log("Getting logout text " + logoutText.toString());
        CustomListeners.test.log(Status.PASS, "Get logout text");
        return getTextFromElement(logoutText);
    }
}
