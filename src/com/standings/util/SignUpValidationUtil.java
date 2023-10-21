package com.standings.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUpValidationUtil {

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,}$");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[A-Z])(?=.*\\d).{8,}$");
    private static final Pattern FULL_NAME_PATTERN = Pattern.compile("^[a-zA-Z]+( [a-zA-Z]+)*$");

	public static boolean checkForEmptyField(String... fields) {
	    for (String field : fields) {
	        if (!field.isEmpty()) {
	            return false;
	        }
	    }
	    return true;
	}


    public static boolean isValidEmail(String email) {
        Matcher matcher = EMAIL_PATTERN.matcher(email);
        return matcher.matches();
    }

    public static boolean isValidPassword(String password) {
        Matcher matcher = PASSWORD_PATTERN.matcher(password);
        return matcher.matches();
    }

    public static boolean isValidFullName(String fullName) {
        Matcher matcher = FULL_NAME_PATTERN.matcher(fullName);
        return matcher.matches();
    }
}
