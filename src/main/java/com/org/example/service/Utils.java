package com.org.example.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    private static final String PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                    "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    public static Boolean validEmail(String email){
        Matcher matcher = Pattern.compile(PATTERN).matcher(email);
        return matcher.matches();
    }

    public static Boolean validPassword(String password){
        return password.length() >= 8 && password.length() <= 16 && password.matches(".*[A-Z].*") && password.matches(".*[a-z].*") && password.matches(".*[0-9].*");
    }

}
