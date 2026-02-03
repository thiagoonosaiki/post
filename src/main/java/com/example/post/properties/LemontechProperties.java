package com.example.post.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "soap")
public class LemontechProperties {

    private String keyClient;

    private String usarname;

    private String password;

    public String getKeyClient() {
        return keyClient;
    }

    public void setKeyClient(String keyClient) {
        this.keyClient = keyClient;
    }

    public String getUsarname() {
        return usarname;
    }

    public void setUsarname(String usarname) {
        this.usarname = usarname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
