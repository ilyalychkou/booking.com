package tests;

import junit.framework.Assert;
import org.junit.Test;
import ui.AccommodationPageObject;
import ui.factories.AccommodationPageObjectFactory;

public class AccommodationTests extends CoreTestCase {

    @Test
    public void testCheckAvailabilityOfRoom()
    {
        int expected_amount_of_available_rooms = 3;
        AccommodationPageObject AccommodationPageObject = AccommodationPageObjectFactory.get(driver);

        AccommodationPageObject.initSearchInput();
        AccommodationPageObject.typeSearchLine("Oslo");

        AccommodationPageObject.initDateInput();
        AccommodationPageObject.chooseDateFromCalendar("2019-11-16");
        AccommodationPageObject.chooseDateFromCalendar("2019-11-17");

        AccommodationPageObject.initRoomSearch();

        int actual_amount_of_available_rooms = AccommodationPageObject.getAmountOfAvailableRooms();
        assertTrue("Amount of avaiable rooms less than " + expected_amount_of_available_rooms,actual_amount_of_available_rooms>=expected_amount_of_available_rooms);

    }

}
