package hrs.utilities;

import gherkin.deps.com.google.gson.Gson;
import hrs.models.LoginRequest;
import hrs.models.ResetPasswordRequest;

import java.util.HashMap;

public class ApiUtils {
    public LoginRequest buildLoginRequest(String username, String password) {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setSource("ClinicianConnect 2");
        loginRequest.setType("credentials");
        loginRequest.setUsername(username);
        loginRequest.setPassword(password);
        return loginRequest;
    }

    public ResetPasswordRequest buildResetRequest(String username) {
        ResetPasswordRequest resetRequest = new ResetPasswordRequest();
        resetRequest.setLanding_url("https://cc.healthrecoverysolutions.com/recovery");
        resetRequest.setUsername(username);
        return resetRequest;
    }

    public String loginJSonBuild (LoginRequest request){
        HashMap<String, Object> data = new HashMap<>();
        data.put("source", request.getSource());
        data.put("type", request.getType());
        data.put("username", request.getUsername());
        data.put("password", request.getPassword());

        HashMap<String, Object> loginRequest = new HashMap<>();
        loginRequest.put("data", data);

        Gson gson = new Gson();
        return gson.toJson(loginRequest);
    }

    public String resetJSonBuild (ResetPasswordRequest request){
        HashMap<String, Object> data = new HashMap<>();
        data.put("username", request.getUsername());
        data.put("landing_url", request.getLanding_url());

        HashMap<String, Object> resetRequest = new HashMap<>();
        resetRequest.put("data", data);

        Gson gson = new Gson();
        return gson.toJson(resetRequest);
    }
}
