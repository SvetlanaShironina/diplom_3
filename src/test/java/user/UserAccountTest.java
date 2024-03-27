package user;

import base.CommonBaseTest;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.apiCreateUser.constantApi.ApiEndpoints;
import site.nomoreparties.stellarburgers.apiCreateUser.user.UserSteps;
import site.nomoreparties.stellarburgers.pages.AccountPage;
import site.nomoreparties.stellarburgers.pages.HomePage;
import site.nomoreparties.stellarburgers.pages.LoginPage;
import site.nomoreparties.stellarburgers.userRandom.UserConstructor;
import site.nomoreparties.stellarburgers.userRandom.UserRandom;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class UserAccountTest extends CommonBaseTest {
    private UserConstructor userConstructor;
    private HomePage homePage;
    private LoginPage loginPage;
    private UserSteps userSteps;

    @Before
    public void setUp2() {
        userConstructor = UserRandom.getUserRandom();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        userSteps = new UserSteps();
        userSteps.createUser(userConstructor);
        homePage.clickButtonLoginAccount();
        loginPage.fillLoginForm(userConstructor.getEmail(), userConstructor.getPassword());
    }

    @Test
    @DisplayName("Click-through to the Personal Account")
    public void transitionToAccount() {
        homePage.clickButtonAccount();
        String actualUrl = driver.getCurrentUrl();

        assertEquals("URL doesn't match", actualUrl, "https://stellarburgers.nomoreparties.site/account");
    }

    @Test
    @DisplayName("Transition from the personal account to the constructor by clicking on the \"Constructor\"")
    public void transitionToConstructor() {
        homePage.clickButtonAccount();
        homePage.clickButtonConstructor();
        String actualUrl = driver.getCurrentUrl();

        assertEquals("URL doesn't match", actualUrl, ApiEndpoints.BASE_URL);
    }

    @Test
    @DisplayName("Transfer from your personal account to the constructor by clicking on the Stellar Burgers logo")
    public void transitionToLogoBurgers() {
        homePage.clickButtonAccount();
        homePage.clickLinkLogoBurgers();
        String actualUrl = driver.getCurrentUrl();

        assertEquals("URL doesn't match", actualUrl, ApiEndpoints.BASE_URL);
    }

    @Test
    @DisplayName("Log out using the \"Log out\" button in your personal account")
    public void logoutUserByLogoutButton() {
        homePage.clickButtonAccount();
        new AccountPage(driver)
                .clickLogoutButton();
        String text = loginPage.getTextLoginForm();

        assertThat("There was no transition to the login page",text, containsString("Вход"));
    }

    @After
    public void clearState() {
        userConstructor = null;
    }
}
