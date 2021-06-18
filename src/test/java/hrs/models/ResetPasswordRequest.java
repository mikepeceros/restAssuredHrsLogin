package hrs.models;

public class ResetPasswordRequest {
    private String username;
    private String landing_url;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLanding_url() {
        return landing_url;
    }

    public void setLanding_url(String landing_url) {
        this.landing_url = landing_url;
    }
}
