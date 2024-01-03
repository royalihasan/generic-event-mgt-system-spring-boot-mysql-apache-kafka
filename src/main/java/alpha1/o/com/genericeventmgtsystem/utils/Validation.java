package alpha1.o.com.genericeventmgtsystem.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    public static final String EMAIL_REGEX =
            "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,6}$";
    public static final String USERNAME_REGEX =
            "^[a-zA-Z0-9._-]{3,}$";

    public static boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isValidUsername(String username) {
        Pattern pattern = Pattern.compile(USERNAME_REGEX);
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }
}
