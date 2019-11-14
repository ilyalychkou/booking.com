package ui;

import org.openqa.selenium.remote.RemoteWebDriver;

public class FlightsPageObject extends MainPageObject {

    protected static String

            ONE_WAY_TAB ="css:label[title='One-way']",
            DEPARTURE_INPUT_FIELD ="css:input[name='destination']",
            FLIGHTS_SEARCH_BUTTON ="css:button[type='submit']",
            ERROR_LABEL ="css:ul.errorMessages",
            DEPARTURE_DATE_FIELD_PLACEHOLDER = "css:div[aria-label='Departure date input']",
            DESTINATION_PLACEHOLDER = "css:input[placeholder='To where?']",
            CALENDAR_DATE_TPL = "css:div[aria-label='{DATE}']",
            FILTER_FOR_AIRCOMPANY_BY_SUBSTRING_TPL = "css:button[aria-label='{AIR COMPANY NAME} only']",
            LOGO_FOR_AIRCOMPANY_BY_SUBSTRING_TPL = "css:img[alt='{AIR COMPANY NAME} logo']";

    public FlightsPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }

    /* TEMPLATES METHODS */
    private static String getDateValue(String date)
    {
        return CALENDAR_DATE_TPL.replace("{DATE}", date);
    }

    private static String getCompanyNameFilterElement(String air_company_name)
        {
            return FILTER_FOR_AIRCOMPANY_BY_SUBSTRING_TPL.replace("{AIR COMPANY NAME}", air_company_name);
        }

    private static String getResultSearchElementByLogo(String air_company_name)
        {
            return LOGO_FOR_AIRCOMPANY_BY_SUBSTRING_TPL.replace("{AIR COMPANY NAME}", air_company_name);
        }


    /* TEMPLATES METHODS */
    public void initDateInput()
        {
            this.waitForElementAndClick(DEPARTURE_DATE_FIELD_PLACEHOLDER,"Cannot find and click search init element", 5);
        }

    public void initFligthSearch()
        {
            this.waitForElementAndClick(FLIGHTS_SEARCH_BUTTON,"Cannot find and click search init element", 5);
        }

    public void initDestinationInput()
        {
            this.waitForElementAndClick(DESTINATION_PLACEHOLDER,"Cannot find and click destination placeholder", 5);
        }

    public void enableOneWayTab()
    {
        this.waitForElementAndClick(ONE_WAY_TAB,"Cannot find and click One way tab", 5);
    }


    public void typeSearchLine (String search_line)
        {
            this.waitForElementAndSendKeys(DEPARTURE_INPUT_FIELD, search_line, "Cannot find and type into search input", 5);
        }


    public void chooseDepartureDateFromCalendar(String date)
        {
            String date_locator= getDateValue(date);
            this.waitForElementAndClick(date_locator,"Cannot find search result with substring" + date,10);
        }


    public void checkFlighBySpecificAirCompany (String air_company_name)
        {

            String filter_locator= getCompanyNameFilterElement(air_company_name);
            this.waitForElementAndClick(filter_locator,"Cannot find filter for air company" + air_company_name,10);

            String logo_locator= getResultSearchElementByLogo(air_company_name);
            this.waitForElementPresent(logo_locator,"Cannot find search result with logo of " + air_company_name + " company");

        }

    public void checkErrorMessageForInvalidDepartureAirport ()
        {
            this.waitForElementPresent(ERROR_LABEL,"Cannot find error message on the Flights screen");
        }

}
