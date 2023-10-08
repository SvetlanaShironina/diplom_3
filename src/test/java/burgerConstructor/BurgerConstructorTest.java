package burgerConstructor;

import base.CommonBaseTest;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pages.HomePage;
import static org.junit.Assert.assertTrue;

public class BurgerConstructorTest extends CommonBaseTest {
    private HomePage homePage;

    @Before
    public void setUp2() {
        homePage = new HomePage(driver);
    }

    @Test
    @DisplayName("Go to the \"Bun\" section")
    public void findBunIngredient() {
        homePage.clickIngredientsSauce();
        String actualClass = homePage.clickIngredientsBun();
        assertTrue(actualClass.contains("tab_tab_type_current__2BEPc"));
    }

    @Test
    @DisplayName("Go to the \"Sauces\" section")
    public void findSauceIngredient() {
        String actualClass = homePage.clickIngredientsSauce();
        assertTrue(actualClass.contains("tab_tab_type_current__2BEPc"));
    }

    @Test
    @DisplayName("Go to the \"Filling\" section")
    public void findFillingIngredient() {
        String actualClass = homePage.clickIngredientsFilling();
        assertTrue(actualClass.contains("tab_tab_type_current__2BEPc"));
    }
}
