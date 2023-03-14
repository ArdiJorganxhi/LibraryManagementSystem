package dev.ardijorganxhi.librarymanagementsystem.core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtils {

    public String validateEmail(String email){
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if(matcher.matches()){
            return email;
        } else {
            return "Email is not valid!";
        }

    }

}
