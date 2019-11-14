package tests;

import org.junit.Test;
import ui.*;
import ui.factories.*;

public class CarRentalTests extends CoreTestCase {


    @Test
    public void testAgePlaceholderDisplayedWhenDriverAgedBetweenCheckboxUnChecked()
    {
        NavigationUI NavigationUI = NavigationUIFactory.get(driver);
        NavigationUI.moveToCarRentalTab();

        CarRentalPageObject CarRentalPageObject = CarRentalPageObjectFactory.get(driver);
        CarRentalPageObject.uncheckDriverAgedBetweenCheckbox();
        CarRentalPageObject.iSAgeInputFieldDisplayed();
    }


}
