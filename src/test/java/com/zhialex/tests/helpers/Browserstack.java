package com.zhialex.tests.helpers;

import com.zhialex.tests.config.CredentialsConfig;
import org.aeonbits.owner.ConfigFactory;

import static io.restassured.RestAssured.given;

public class Browserstack {

    public static String videoUrl(String sessionId) {

        CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);

        return given()
                .auth().basic(config.user(), config.key())
                .when()
                .get("https://api.browserstack.com/app-automate/sessions/" + sessionId + ".json")
                .then()
                .statusCode(200)
                .extract()
                .path("automation_session.video_url");
    }
}
