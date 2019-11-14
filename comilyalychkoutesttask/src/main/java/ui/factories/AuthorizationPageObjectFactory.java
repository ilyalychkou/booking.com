package ui.factories;

import org.openqa.selenium.remote.RemoteWebDriver;
import ui.AuthorizationPageObject;

public class AuthorizationPageObjectFactory {

    public static AuthorizationPageObject get(RemoteWebDriver driver)
    {
        return new AuthorizationPageObject (driver);
    }
}
