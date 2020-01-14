package tests;

import models.YandexTestData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.YandexPage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static helper.JsonUtils.generateListData;

public class YandexTest extends TestBase {
    private String dataFile = "src\\test\\resources\\test_data\\yandex_test_data.json";
    private YandexPage mainPage;

    @DataProvider(name="data")
    public Iterator<Object> testData(){
        List<YandexTestData> data = generateListData(dataFile, YandexTestData.class);
        List<Object> res = new ArrayList<Object>();
        for(YandexTestData item:data){
            res.add(item);
        }
        return res.iterator();
    }
    @BeforeMethod
    public void given(){
        mainPage = navigation.goToMain();
    }

    @Test(description = "Проверка поля ввода", dataProvider = "data")
    public void checkInputField(YandexTestData value){
        mainPage
                .setValueSearchField(value.getSearchValue())
                .checkValuesListIsVisible()
                .printAllPossibleValues();
    }

    @Test(description = "Проверка отображения вкладки 'Картинки'")
    public void checkImagesTab(){
        SoftAssert soft = new SoftAssert();
        mainPage
                .checkImagesLinkIsVisible()
                .clickImagesLink()
                .setSoftAssert(soft)
                .checkMenuVisibility(true)
                .checkImagesPresent();
        soft.assertAll();
    }
}
