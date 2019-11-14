package ui;

import org.openqa.selenium.remote.RemoteWebDriver;

public class CarRentalPageObject extends MainPageObject {

    protected static String

            AGE_PLACEHOLDER = "css:label[for='driverAgeInput']",
            DRIVERS_AGE_CHECKBOX = "css:label[class='bui-checkbox driverAgeCheckboxLabel']";

    public CarRentalPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }

    public void uncheckDriverAgedBetweenCheckbox()
        {

            this.waitForElementAndClick(DRIVERS_AGE_CHECKBOX,"Cannot find and unchecked DriverAgeCheckbox", 15);
        }

    public void iSAgeInputFieldDisplayed()
        {
            this.waitForElementAndClick(AGE_PLACEHOLDER,
                    "Age Input Field does not displayed when driver age checkbox unchecked", 5);
        }

}






