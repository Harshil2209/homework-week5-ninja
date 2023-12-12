package com.tutorialninja.pages;

import com.tutorialninja.customlisteners.CustomListeners;
import com.tutorialninja.utility.Utility;

public class ComponentPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Components')]")
    WebElement componentsText;

    public String getComponentsText() {
        Reporter.log("Getting components text " + componentsText.toString());
        CustomListeners.test.log(Status.PASS, "Get components text");
        return getTextFromElement(componentsText);
    }

}
