package ui;

import org.openqa.selenium.remote.RemoteWebDriver;

public class NavigationUI extends MainPageObject{


    protected static String
            MY_LISTS_BUTTON = "css:a[data-acc-aa-db='menu_wishlist']",
            MY_ACCOUNT_BUTTON = "css:span.user_name_block",
            FLIGHTS_TAB = "css:svg.bk-icon.-iconset-airplane",
            CAR_RENTAL_TAB = "css:svg.bk-icon.-iconset-car_front",
            TOURS_AND_ACTIVITIES_TAB = "css:svg.bk-icon.-iconset-attractions";

    public NavigationUI (RemoteWebDriver driver)
    {
        super(driver);
    }

    public void openAccountMenuAndClickMyLists()
        {
            this.waitForElementAndClick(MY_ACCOUNT_BUTTON,"Cannot find and click navigation menu button", 5);
            this.waitForElementAndClick(MY_LISTS_BUTTON,"Cannot find and click navigation menu button", 5);

        }

    public void moveToFlightsTab()
    {
        this.waitForElementAndClick(FLIGHTS_TAB,"Cannot find and click flights tab", 5);
    }

    public void moveToCarRentalTab()
        {
            this.waitForElementAndClick(CAR_RENTAL_TAB,"Cannot find and click car rental tab", 5);
        }

    public void moveToToursAndActivitiesTab()
        {
            this.waitForElementAndClick(TOURS_AND_ACTIVITIES_TAB,"Cannot find and click tours and activities tab", 15);
        }

}
