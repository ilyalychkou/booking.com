package ui.factories;

import org.openqa.selenium.remote.RemoteWebDriver;
import ui.AccommodationPageObject;

public class AccommodationPageObjectFactory {

    public static AccommodationPageObject get(RemoteWebDriver driver)
        {
            return new AccommodationPageObject (driver);
        }

}

