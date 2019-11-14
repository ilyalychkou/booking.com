package tests;

import org.junit.Test;
import ui.*;
import ui.factories.*;

public class MyListsTests extends CoreTestCase {


    @Test
    public void testAddLocationToMyLists()
    {
        AuthorizationPageObject AuthorizationPageObject = AuthorizationPageObjectFactory.get(driver);
        AuthorizationPageObject.loginWithExistedGoogleAccount();

        AccommodationPageObject AccommodationPageObject = AccommodationPageObjectFactory.get(driver);

        AccommodationPageObject.initSearchInput();
        AccommodationPageObject.typeSearchLine("Paris");
        AccommodationPageObject.initDateInput();
        AccommodationPageObject.chooseDateFromCalendar("2019-11-14");
        AccommodationPageObject.chooseDateFromCalendar("2019-11-16");
        AccommodationPageObject.initRoomSearch();
        AccommodationPageObject.clickLocationSearchResult();

        LocationPageObject LocationPageObject = LocationPageObjectFactory.get(driver);
        LocationPageObject.saveLocationToMyLists();

        NavigationUI NavigationUI = NavigationUIFactory.get(driver);
        NavigationUI.openAccountMenuAndClickMyLists();

        MyListsPageObject MyListsPageObject = MyListsPageObjectFactory.get(driver);
        MyListsPageObject.checkSavedLocationPresentInMyLists();

    }
}
