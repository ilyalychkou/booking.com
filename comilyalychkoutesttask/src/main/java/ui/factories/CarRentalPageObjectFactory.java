package ui.factories;

import org.openqa.selenium.remote.RemoteWebDriver;
import ui.CarRentalPageObject;

public class CarRentalPageObjectFactory {

    public static CarRentalPageObject get(RemoteWebDriver driver)
    {
        return new CarRentalPageObject (driver);
    }
}
