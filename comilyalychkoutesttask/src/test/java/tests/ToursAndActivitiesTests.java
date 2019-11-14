package tests;

import org.junit.Test;
import ui.NavigationUI;
import ui.ToursAndActivitiesPageObject;
import ui.factories.NavigationUIFactory;
import ui.factories.ToursAndActivitiesPageObjectFactory;

public class ToursAndActivitiesTests extends CoreTestCase {

    @Test
    public void testSearchForTourAndCheckResultByTitle()
    {
        NavigationUI NavigationUI = NavigationUIFactory.get(driver);
        NavigationUI.moveToToursAndActivitiesTab();

        ToursAndActivitiesPageObject ToursAndActivitiesPageObject = ToursAndActivitiesPageObjectFactory.get(driver);
        ToursAndActivitiesPageObject.chooseCityByName("Amsterdam");

        ToursAndActivitiesPageObject.initSearchInput();
        ToursAndActivitiesPageObject.typeSearchLine("Rijksmuseum");

        ToursAndActivitiesPageObject.moveFocusFromSearchField();
        ToursAndActivitiesPageObject.checkSearchResultsByTitle("Rijksmuseum");
    }

}
