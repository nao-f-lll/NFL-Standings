package credentials;

import java.util.HashMap;

public class UserNameAndPass {

    HashMap<String, String> loginInfo = new HashMap<String, String>();

    public UserNameAndPass() {

        loginInfo.put("naoufal", "naoufal");
        loginInfo.put("adioual@gmail.com", "ahmed");
        loginInfo.put("ahmadhkary53@gmail.com", "ahmad");
        loginInfo.put("lucasbarru3@gmail.com", "lucas");
        loginInfo.put("sendoave@gmail.com", "sendoa");
        loginInfo.put("sendoave@gmail.com", "sendoa");
       
        
    }
      
    
    // getters
    public HashMap<String, String> getLogingInfo() { return loginInfo; }
}