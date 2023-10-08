package user;

import base.CommonBaseTest;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.apiCreateUser.user.UserSteps;
import site.nomoreparties.stellarburgers.pages.ForgotPasswordPage;
import site.nomoreparties.stellarburgers.pages.HomePage;
import site.nomoreparties.stellarburgers.pages.LoginPage;
import site.nomoreparties.stellarburgers.pages.RegisterPage;
import site.nomoreparties.stellarburgers.userRandom.UserConstructor;
import site.nomoreparties.stellarburgers.userRandom.UserRandom;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

public class UserLoginTest extends CommonBaseTest {
    private UserConstructor userConstructor;
    private HomePage homePage;
    private LoginPage loginPage;
    private UserSteps userSteps;
    private RegisterPage registerPage;
    private ForgotPasswordPage forgotPasswordPage;

   @Before
    public void setUp2() {
        userConstructor = UserRandom.getUserRandom();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        userSteps = new UserSteps();
        userSteps.createUser(userConstructor);
    }

    @Test
    @DisplayName("Log in using the \"Log in to account\" button on the main page")
    public void loginUserByLoginButton(){
        homePage.clickButtonLoginAccount();
        loginPage.fillLoginForm(userConstructor.getEmail(), userConstructor.getPassword());
        boolean isDisplayed = loginPage.buttonLoginIsDisplayed();
        String text = loginPage.getTextButtonCreateOrder();

        assertTrue(isDisplayed);
        assertThat("There was no transition to the main page after registration",text, containsString("Оформить заказ"));

    }

    @Test
    @DisplayName("Login via the \"Personal Account\" button")
    public void loginUserByAccountButton(){
        homePage.clickButtonAccount();
        loginPage.fillLoginForm(userConstructor.getEmail(), userConstructor.getPassword());
        boolean isDisplayed = loginPage.buttonLoginIsDisplayed();
        String text = loginPage.getTextButtonCreateOrder();

        assertTrue(isDisplayed);
        assertThat("There was no transition to the main page after registration",text, containsString("Оформить заказ"));
    }

    @Test
    @DisplayName("Login via the button in the registration form")
    public void loginUserByRegisterPage(){
        registerPage = new RegisterPage(driver);

        homePage.clickButtonAccount();
        loginPage.clickRegisterLink();
        registerPage.clickLoginLink();
        loginPage.fillLoginForm(userConstructor.getEmail(), userConstructor.getPassword());
        boolean isDisplayed = loginPage.buttonLoginIsDisplayed();
        String text = loginPage.getTextButtonCreateOrder();

        assertTrue(isDisplayed);
        assertThat("There was no transition to the main page after registration",text, containsString("Оформить заказ"));
    }

    @Test
    @DisplayName("Login via the button in the password recovery form")
    public void loginUserByForgotPasswordPage(){
        forgotPasswordPage = new ForgotPasswordPage(driver);

        homePage.clickButtonAccount();
        loginPage.clickForgotPasswordLink();
        forgotPasswordPage.clickLoginLink();
        loginPage.fillLoginForm(userConstructor.getEmail(), userConstructor.getPassword());
        boolean isDisplayed = loginPage.buttonLoginIsDisplayed();
        String text = loginPage.getTextButtonCreateOrder();

        assertTrue(isDisplayed);
        assertThat("There was no transition to the main page after registration",text, containsString("Оформить заказ"));
    }

    @After
    public void clearState() {
        userConstructor = null;
    }
}
