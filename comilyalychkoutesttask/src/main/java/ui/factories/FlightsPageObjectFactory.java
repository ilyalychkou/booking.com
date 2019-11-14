package ui.factories;

import org.openqa.selenium.remote.RemoteWebDriver;
import ui.FlightsPageObject;

public class FlightsPageObjectFactory {

    public static FlightsPageObject get(RemoteWebDriver driver)
    {
        return new FlightsPageObject (driver);
    }
}
