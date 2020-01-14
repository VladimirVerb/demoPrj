package helper;

import org.openqa.selenium.WebElement;

public class Actions {

    public void setValue(WebElement webElement, String value){
        webElement.click();
        webElement.clear();
        webElement.sendKeys(value);
    }
}
