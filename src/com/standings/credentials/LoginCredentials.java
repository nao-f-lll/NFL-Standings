package com.standings.credentials;

import java.util.HashMap;

public class LoginCredentials {

    HashMap<String, String> loginInfo = new HashMap<String, String>();

    public LoginCredentials() {
        loginInfo.put("naoufal", "naoufal");  
    }
      
    
    // getters
    public HashMap<String, String> getLogingInfo() { return loginInfo; }
}
