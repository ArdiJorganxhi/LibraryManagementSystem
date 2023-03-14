package dev.ardijorganxhi.librarymanagementsystem.core;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ValidationUtils {

    public String validateEmail(String email) throws Exception{
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if(matcher.matches()){
            return email;
        } else {
            throw new Exception("Email is not valid!");
        }

    }


}
