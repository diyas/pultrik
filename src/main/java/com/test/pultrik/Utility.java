package com.test.pultrik;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utility {

    public static boolean validateForm(String regex, String patern){
        //String regex = "^[a-zA-Z]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(patern);
        return match.matches();
    }
}
