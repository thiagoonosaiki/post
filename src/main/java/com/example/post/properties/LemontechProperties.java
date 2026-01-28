package com.example.post.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "soap.lemontech")
public class LemontechProperties {

    private String keyClient;
    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getKeyClient() {
        return keyClient;
    }

    public void setKeyClient(String keyClient) {
        this.keyClient = keyClient;
    }
}
