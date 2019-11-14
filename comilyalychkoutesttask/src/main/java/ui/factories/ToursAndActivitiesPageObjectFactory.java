package ui.factories;

import org.openqa.selenium.remote.RemoteWebDriver;
import ui.ToursAndActivitiesPageObject;

public class ToursAndActivitiesPageObjectFactory {

    public static ToursAndActivitiesPageObject get(RemoteWebDriver driver)
    {
        return new ToursAndActivitiesPageObject (driver);
    }
}
