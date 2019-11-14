package ui;

import org.openqa.selenium.remote.RemoteWebDriver;

public class AuthorizationPageObject extends MainPageObject{

    private static final String
            SIGN_IN_BUTTON = "xpath://div/ul/li[5]/a/div/span",
            GOOGLE_LOGIN_FIELD = "css:input#username",
            GOOGLE_PASSWORD_FIELD = "css:input#password",
            BUTTON_SUBMIT = "css:button[type='submit']",
            SIGN_IN_WITH_GOOGLE_BUTTON = "css:a[data-ga-label='Sign in with google']";

    public AuthorizationPageObject (RemoteWebDriver driver){
        super(driver);
    }

    public void loginWithExistedGoogleAccount()
        {

            String google_login = "iltest1980@gmail.com";
            String google_password = "1980test";

            this.waitForElementPresent(SIGN_IN_BUTTON,"Cannot find 'Sign In' button", 15);
            this.waitForElementAndClick(SIGN_IN_BUTTON,"Cannot find  and click 'Sign In' button", 15);
            this.waitForElementPresent(SIGN_IN_WITH_GOOGLE_BUTTON,"Cannot find 'Sign In With Google' button", 15);
            this.waitForElementAndSendKeys(GOOGLE_LOGIN_FIELD, google_login, "Cannot find and Google login Field", 15);
            this.waitForElementAndClick(BUTTON_SUBMIT,"Cannot find  and click 'Sign In' button", 15);
            this.waitForElementAndSendKeys(GOOGLE_PASSWORD_FIELD, google_password, "Cannot find and Google login Field", 15);
            this.waitForElementAndClick(BUTTON_SUBMIT,"Cannot find  and click 'Sign In' button", 15);

        }
}
