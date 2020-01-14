package pages;

import helper.ApplicationManager;
import helper.Config;
import org.openqa.selenium.WebDriver;

public class Navigation {
    private WebDriver wd;

    public Navigation(WebDriver wd){
        this.wd = wd;
    }

    public YandexPage goToMain(){
        wd.get(Config.getMainUrl());
        return new YandexPage(wd);
    }
}
