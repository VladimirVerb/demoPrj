package tests;

import org.testng.annotations.*;
import helper.ApplicationManager;
import pages.Navigation;

public class TestBase {
    protected Navigation navigation;

    protected static ApplicationManager appManager = new ApplicationManager();

    @BeforeSuite
    public void up() throws Exception{
        appManager.initWD();
        navigation = new Navigation(appManager.getDriver());
    }

    @AfterSuite(alwaysRun = true)
    public void down(){
        appManager.stopWD();
    }

}
