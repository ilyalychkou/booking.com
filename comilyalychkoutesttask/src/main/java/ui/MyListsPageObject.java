package ui;

import org.openqa.selenium.remote.RemoteWebDriver;

public class MyListsPageObject extends MainPageObject {

    protected static String

            MY_LIST_CHECKBOX = "css:svg.bk-icon.-iconset-dropdown.bui-dropdown__arrows",
            MY_LIST_LOCATIONS_ITEM = "css:div[data-id='505471442']",
            ITEM_SAVED_IN_MY_LIST = "css:li.bui-carousel__item";

    public MyListsPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }

    public  void checkSavedLocationPresentInMyLists()
        {
            this.waitForElementAndClick(MY_LIST_CHECKBOX,"Cannot find and open checkbox", 10);
            this.waitForElementAndClick(MY_LIST_LOCATIONS_ITEM,"Cannot find and choose my list item", 10);
            this.waitForElementPresent(ITEM_SAVED_IN_MY_LIST,"Cannot find saved location in my list", 10);
        }
}
