package dev.mistarille.domain.user.usecase.userlogin;

public class UserLoginItem {
    private String userName;
    private String userPassword;
    private String projectAccessToken;

    public UserLoginItem() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getProjectAccessToken() {
        return projectAccessToken;
    }

    public void setProjectAccessToken(String projectAccessToken) {
        this.projectAccessToken = projectAccessToken;
    }
}
