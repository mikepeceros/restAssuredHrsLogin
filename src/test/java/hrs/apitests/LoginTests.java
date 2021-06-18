package hrs.apitests;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import hrs.framework.Endpoints;
import hrs.utilities.ApiUtils;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginTests extends Endpoints {

    private static final Logger LOG = LoggerFactory.getLogger(LoginTests.class);
    private ApiUtils apiUtils = new ApiUtils();

    @Test()
    @DisplayName("LOGIN - successful: MUST RETURN 200")
    public void test_01(){
        Response response = RestAssured
                .given()
                .spec(loginEndpoint())
                .contentType(ContentType.JSON)
                .body(apiUtils.loginJSonBuild(
                        apiUtils.buildLoginRequest("validUser","validPwd")))
                .post();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.SC_OK);
    }

    @Test()
    @DisplayName("LOGIN - Invalid creds: MUST RETURN 401")
    public void test_02(){
        Response response = RestAssured
                .given()
                .spec(loginEndpoint())
                .contentType(ContentType.JSON)
                .body(apiUtils.loginJSonBuild(
                        apiUtils.buildLoginRequest("invalidUser","randomPwd")))
                .post();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.SC_UNAUTHORIZED);
    }

    @Test()
    @DisplayName("LOGIN - Missing fields: MUST RETURN 400 as bad request")
    public void test_03(){
        Response response = RestAssured
                .given()
                .spec(loginEndpoint())
                .contentType(ContentType.JSON)
                .body(apiUtils.loginJSonBuild(
                        apiUtils.buildLoginRequest("invalidUser","")))
                .post();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.SC_BAD_REQUEST);
    }

    @Test()
    @DisplayName("RESET PWD - Successful: MUST RETURN 204")
    public void test_04(){
        Response response = RestAssured
                .given()
                .spec(resetPwdEndpoint())
                .contentType(ContentType.JSON)
                .body(apiUtils.resetJSonBuild(
                        apiUtils.buildResetRequest("validUser")))
                .post();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.SC_NO_CONTENT);
    }

    @Test()
    @DisplayName("RESET PWD - Missing user: MUST RETURN 400")
    public void test_05(){
        Response response = RestAssured
                .given()
                .spec(loginEndpoint())
                .body(apiUtils.resetJSonBuild(
                        apiUtils.buildResetRequest("")))
                .post();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.SC_BAD_REQUEST);
    }
}