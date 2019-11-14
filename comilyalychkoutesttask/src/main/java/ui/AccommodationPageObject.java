package ui;

import org.openqa.selenium.remote.RemoteWebDriver;


public class AccommodationPageObject extends MainPageObject {

    protected static String
            ACCOMMODATION_SEARCH_BUTTON ="css:button[type='submit']",
            ACCOMMODATION_SEARCH_FIELD ="css:input[type='search']",
            ACCOMMODATION_SEARCH_INIT_ELEMENT = "css:input[placeholder='Where are you going?']",
            CALENDAR_PICKER_BUTTON = "css:svg[class='bk-icon -experiments-calendar sb-date-picker_icon-svg']",
            ROOM_NOT_AVAILABLE_BANNER = "css:h3.fe_banner__title",
            SEARCH_ACCOMMODATION_RESULT_ELEMENT = "css:div.sr_item",
            SEARCH_LOCATION_RESULT = "css:svg.bk-icon.-streamline-arrow_nav_right",
            CALENDAR_DATE_TPL="css:td[data-date='{DATE}']";

    public AccommodationPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }

    /* TEMPLATES METHODS */
    private static String getDateValue(String date)
    {
        return CALENDAR_DATE_TPL.replace("{DATE}", date);
    }

    public void initSearchInput()
        {
            this.waitForElementAndDoubleClick(ACCOMMODATION_SEARCH_INIT_ELEMENT,"Cannot find and click search init element", 5);
            this.waitForElementPresent(ACCOMMODATION_SEARCH_INIT_ELEMENT,"Cannot find search input after clicking search init element");
        }

    public void initDateInput()
        {
            this.waitForElementAndClick(CALENDAR_PICKER_BUTTON,"Cannot find and click search init element", 5);
            this.waitForElementPresent(CALENDAR_PICKER_BUTTON,"Cannot find search input after clicking search init element");
        }

    public void initRoomSearch()
        {
            this.waitForElementAndClick(ACCOMMODATION_SEARCH_BUTTON,"Cannot find and click search init element", 5);
            this.waitForElementPresent(ACCOMMODATION_SEARCH_BUTTON,"Cannot find search input after clicking search init element");
        }

    public  void clickLocationSearchResult()
        {
            this.waitForElementAndClick(SEARCH_LOCATION_RESULT,"Cannot find and click search location result", 20);
        }

    public void typeSearchLine (String search_line)
        {
            this.waitForElementAndSendKeys(ACCOMMODATION_SEARCH_FIELD, search_line, "Cannot find and type into search input", 5);
        }


    public int getAmountOfAvailableRooms ()
        {
            int amount_of_search_accommodation_results;
            int amount_of_unavailable_rooms;

            amount_of_search_accommodation_results =  this.getAmountOfElements(SEARCH_ACCOMMODATION_RESULT_ELEMENT);
            amount_of_unavailable_rooms =  this.getAmountOfElements(ROOM_NOT_AVAILABLE_BANNER);

            return amount_of_search_accommodation_results - amount_of_unavailable_rooms;
        }


    public void chooseDateFromCalendar(String date)
        {
            String date_locator= getDateValue(date);
            this.waitForElementAndClick(date_locator,"Cannot find search result with substring" + date,10);
        }

}
