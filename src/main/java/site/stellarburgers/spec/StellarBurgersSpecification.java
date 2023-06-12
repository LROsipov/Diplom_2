package site.stellarburgers.spec;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import site.stellarburgers.dto.LoginJson;
import site.stellarburgers.dto.OrderJson;
import site.stellarburgers.dto.UserJson;

import java.util.Arrays;

public class StellarBurgersSpecification {
    public static RequestSpecification forStellaBurgers(UserJson userJson) {
        return createDefaultSpec().setBody(userJson).build();
    }

    public static RequestSpecification forLogin(LoginJson loginJson) {
        return createDefaultSpec().setBody(loginJson).build();
    }

    public static RequestSpecification delete(String accessToken) {
        return createDefaultSpec().addHeader("Authorization", accessToken).build();
    }

    public static RequestSpecification changeUser(UserJson userJson, String accessToken) {
        return createDefaultSpec().addHeader("Authorization", accessToken).setBody(userJson).build();
    }

    public static RequestSpecification forOrder(String accessToken) {
        return createDefaultSpec().addHeader("Authorization", accessToken).build();
    }

    public static RequestSpecification createOrder(OrderJson orderJson, String accessToken) {
        return createDefaultSpec().addHeader("Authorization", accessToken).setBody(orderJson).build();
    }


    public static RequestSpecBuilder createDefaultSpec() {
        return new RequestSpecBuilder()
                .setBaseUri("https://stellarburgers.nomoreparties.site")
                .setBasePath("/api/")
                .setContentType(ContentType.JSON)
                .addFilters(Arrays.asList(new RequestLoggingFilter(), new ResponseLoggingFilter(), new AllureRestAssured()));
    }
}
