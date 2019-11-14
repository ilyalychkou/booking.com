package tests;

import org.junit.Test;
import ui.FlightsPageObject;
import ui.NavigationUI;
import ui.factories.FlightsPageObjectFactory;
import ui.factories.NavigationUIFactory;

public class FlightTests extends CoreTestCase {


    @Test
    public void testFilterForSpecificAirCompanyOnly()
    {
        NavigationUI NavigationUI = NavigationUIFactory.get(driver);
        NavigationUI.moveToFlightsTab();

        FlightsPageObject FlightsPageObject = FlightsPageObjectFactory.get(driver);

        FlightsPageObject.enableOneWayTab();

        FlightsPageObject.initDestinationInput();

        FlightsPageObject.typeSearchLine("BCN");

        FlightsPageObject.initDateInput();
        FlightsPageObject.chooseDepartureDateFromCalendar("November 30");

        FlightsPageObject.initFligthSearch();
        FlightsPageObject.checkFlighBySpecificAirCompany("airBaltic");
    }



    @Test
    public void testCheckErrorMessageForInvalidOriginAirport()
    {
        NavigationUI NavigationUI = NavigationUIFactory.get(driver);
        NavigationUI.moveToFlightsTab();

        FlightsPageObject FlightsPageObject = FlightsPageObjectFactory.get(driver);

        FlightsPageObject.enableOneWayTab();

        FlightsPageObject.initDestinationInput();

        FlightsPageObject.typeSearchLine("FGHBJ");

        FlightsPageObject.initDateInput();
        FlightsPageObject.chooseDepartureDateFromCalendar("November 30");

        FlightsPageObject.initFligthSearch();
        FlightsPageObject.checkErrorMessageForInvalidDepartureAirport();
    }
}
