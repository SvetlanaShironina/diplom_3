package site.nomoreparties.stellarburgers.apiCreateUser.config;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import site.nomoreparties.stellarburgers.apiCreateUser.constantApi.ApiEndpoints;

import static io.restassured.RestAssured.given;

public class RequestSpec {
    public static RequestSpecification requestSpec() {
        return given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(ApiEndpoints.BASE_URL);
    }
}
