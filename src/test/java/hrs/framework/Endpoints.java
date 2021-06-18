package hrs.framework;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class Endpoints {

    private final String BASE_URL = "https://gateway.healthrecoverysolutions.com/v1";
    private final String TOKENS = "tokens";
    private final String RESET_PASSWORD = "password-reset-tokens";

    public RequestSpecification loginEndpoint(){
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri(BASE_URL);
        builder.setBasePath(TOKENS);
        return builder.build();
    }

    public RequestSpecification resetPwdEndpoint(){
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri(BASE_URL);
        builder.setBasePath(RESET_PASSWORD);
        return builder.build();
    }
}