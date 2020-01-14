package pages;

import helper.Actions;
import helper.ErrorUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class ImagesPage  extends Actions {
    private WebDriver drv;
    private SoftAssert soft;
    private String error = "Блок картинки: ошибка: %s";

    @FindBy(id="root")
    private WebElement mainBlock;

    @FindBy(className="cl-header-under-navigation__menu")
    private WebElement menu;

    @FindBy(className="cl-teaser__picture")
    private List<WebElement> images;

    public ImagesPage(WebDriver drv){
        this.drv=drv;
        PageFactory.initElements(drv, this);

        Assert.assertTrue(mainBlock.isDisplayed(), "Страница не загрузилась");
    }

    public ImagesPage setSoftAssert(SoftAssert soft){
        this.soft = soft;
        return this;
    }

    public ImagesPage checkMenuVisibility(boolean isVisible){
        soft.assertEquals(menu.isDisplayed(), isVisible, String.format(error,
                "Ожидалось, что меню будет" + ErrorUtils.expectedVisible(isVisible)));
        return this;
    }

    public ImagesPage checkImagesPresent(){
        soft.assertTrue(images.size() > 0, "На экране отсутсвуют изображения");
        return this;
    }
}
