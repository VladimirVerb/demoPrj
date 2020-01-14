package helper;
import ru.yandex.qatools.properties.PropertyLoader;
import ru.yandex.qatools.properties.annotations.Property;
import ru.yandex.qatools.properties.annotations.Resource;

@Resource.Classpath("test.properties")
public class Config {
    private static Config config = new Config();

    @Property("main.url")
    private static String mainUrl;

    @Property("drv.path")
    private static String drvPath;

    @Property("browser")
    private static String browser;

    private Config() {
        PropertyLoader.populate(this);
    }

    public static String getMainUrl() {
        return mainUrl;
    }

    public static String getDrvPath() {
        return drvPath;
    }

    public static String getBrowser() {
        return browser;
    }
}
