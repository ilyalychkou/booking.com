package ui.factories;

import org.openqa.selenium.remote.RemoteWebDriver;
import ui.MyListsPageObject;

public class MyListsPageObjectFactory {

    public static MyListsPageObject get(RemoteWebDriver driver)
    {
        return new MyListsPageObject (driver);
    }
}
