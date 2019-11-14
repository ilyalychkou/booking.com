package ui.factories;

import org.openqa.selenium.remote.RemoteWebDriver;
import ui.NavigationUI;

public class NavigationUIFactory {
    public static NavigationUI get(RemoteWebDriver driver)
    {
        return new NavigationUI (driver);
    }
}
