package ui;

import org.openqa.selenium.remote.RemoteWebDriver;

public class LocationPageObject extends MainPageObject {

    protected static String

            SAVE_BUTTON = "css:svg[role='presentation']",
            MY_LIST_LOCATIONS_BUTTON = "css:input[data-list-id='505471442']";

    public LocationPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }

    public  void saveLocationToMyLists()
        {
            this.waitForElementAndClick(SAVE_BUTTON,"Cannot find and click save button", 20);
            this.waitForElementAndClick(MY_LIST_LOCATIONS_BUTTON,"Cannot find and click my list locations button", 20);
        }

}
