package ui;

import org.openqa.selenium.remote.RemoteWebDriver;

public class ToursAndActivitiesPageObject extends MainPageObject {

    protected static String

            ACTIVITY_SEARCH_INIT_ELEMENT = "css:input[placeholder='Search things to do']",
            ACTIVITY_INPUT_FIELD = "css:input[type='text']",
            MOST_VISITED_PLACES_LABEL = "css:h3[class='css-c8ykx5']",
            SEARCH_INPUT_BY_TITLE_TPL = "css:a[title='{TITLE}']",
            CHOOSE_CITY_BY_NAME_TPL = "css:img[alt='{NAME}']";

    public ToursAndActivitiesPageObject (RemoteWebDriver driver)
    {
        super(driver);
    }

    private static String getResultSearchElementByTitle(String title)
        {
            return SEARCH_INPUT_BY_TITLE_TPL.replace("{TITLE}", title);
        }

    private static String getCityLocatorByName(String name)
    {
        return CHOOSE_CITY_BY_NAME_TPL.replace("{NAME}", name);
    }

    public  void checkSearchResultsByTitle (String title)
        {
            String search_result_locator= getResultSearchElementByTitle(title);
            this.waitForElementPresent(search_result_locator,"Cannot find search result with title " + title);
        }

    public  void chooseCityByName (String name)
        {
            String city_by_name_locator= getCityLocatorByName(name);
            this.waitForElementAndClick(city_by_name_locator,"Cannot find search result with name " + name,10);
        }

    public void initSearchInput()
        {
            this.waitForElementAndClick(ACTIVITY_SEARCH_INIT_ELEMENT,"Cannot find and click search init element", 5);
            this.waitForElementPresent(ACTIVITY_SEARCH_INIT_ELEMENT,"Cannot find search input after clicking search init element");
        }

    public void typeSearchLine (String search_line)
        {
            this.waitForElementAndSendKeys(ACTIVITY_INPUT_FIELD, search_line, "Cannot find and type into search input", 5);
        }

    public void moveFocusFromSearchField()
        {
            this.waitForElementAndClick(MOST_VISITED_PLACES_LABEL,"Cannot find and click showing results label", 5);
        }
}
