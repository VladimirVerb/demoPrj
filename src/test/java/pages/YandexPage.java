package pages;

import helper.Actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import helper.Log;

import java.util.List;


public class YandexPage extends Actions {
    private WebDriver drv;

    @FindBy(id="text")
    private WebElement searchInputField;

    @FindBy(xpath = "//div[@class='popup__getposoffix']")
    private WebElement popupDiv;

    @FindBy(className = "suggest2-item__text")
    private List<WebElement> possibleValues;

    @FindBy(linkText = "Картинки")
    private WebElement imagesLink;

    public YandexPage(WebDriver driver) {
        this.drv=driver;
        PageFactory.initElements(driver, this);
    }

    public YandexPage setValueSearchField(String value){
        setValue(searchInputField,value);
        return this;
    }

    public YandexPage checkValuesListIsVisible(){
        Assert.assertTrue(possibleValues.size() > 0, "Список доступных значений отсутствует");
        return this;
    }

    public YandexPage printAllPossibleValues(){
        int index=0;
        Log.info("Были найдены следующие доступные значение:");
        for(WebElement element:possibleValues) {
            Log.info(String.format("%d : %s",index++,element.getText()));
        }
        return this;
    }

    public YandexPage checkImagesLinkIsVisible(){
        Assert.assertTrue(imagesLink.isDisplayed(), "Отсутсвует ссылка на картинки");
        return this;
    }

    public ImagesPage clickImagesLink(){
        imagesLink.click();
        return new ImagesPage(drv);
    }
}
