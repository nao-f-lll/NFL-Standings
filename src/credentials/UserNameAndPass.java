package credentials;

import java.util.HashMap;

public class UserNameAndPass {

    HashMap<String, String> loginInfo = new HashMap<String, String>();

    public UserNameAndPass() {

        loginInfo.put("lyamaninawfal4@gmail.com", "naoufal");
        loginInfo.put("ahmed", "ahmed");
        loginInfo.put("ahmad", "ahmad");
        loginInfo.put("lucas", "lucas");
        loginInfo.put("sendoa", "sendoa");
    }

    
    // getters
    public HashMap<String, String> getLogingInfo() { return loginInfo; }
}