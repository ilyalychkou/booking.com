package tests;

import junit.framework.TestCase;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CoreTestCase extends TestCase{

    protected RemoteWebDriver driver;

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        driver = Platform.getInstance().getDriver();
        this.openHomePageForMobileWeb();
    }

    @Override
    protected void tearDown() throws Exception
    {
        {
            driver.quit();
            super.tearDown();
        }
    }

    protected void openHomePageForMobileWeb()
    {
        if(Platform.getInstance().isMW())
        {

            driver.get("https://booking.com");
        } else {

            System.out.println("Method openHomePageForMobileWeb() does nothing for platform " + Platform.getInstance().getPlatformVar());
        }
    }

}

