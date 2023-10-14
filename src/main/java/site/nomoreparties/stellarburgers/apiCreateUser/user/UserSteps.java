package site.nomoreparties.stellarburgers.apiCreateUser.user;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import site.nomoreparties.stellarburgers.apiCreateUser.config.RequestSpec;
import site.nomoreparties.stellarburgers.apiCreateUser.constantApi.ApiEndpoints;
import site.nomoreparties.stellarburgers.userRandom.UserConstructor;

public class UserSteps extends RequestSpec {

    @Step("Регистрация нового юзера /api/auth/register")
    public ValidatableResponse createUser(UserConstructor userConstructor) {
        return requestSpec()
                .body(userConstructor)
                .when()
                .post(ApiEndpoints.USER_CREATE_POST)
                .then();
    }
}