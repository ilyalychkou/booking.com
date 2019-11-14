package ui.factories;

import org.openqa.selenium.remote.RemoteWebDriver;
import ui.LocationPageObject;

public class LocationPageObjectFactory {

    public static LocationPageObject get(RemoteWebDriver driver)
    {
        return new LocationPageObject (driver);
    }
}
