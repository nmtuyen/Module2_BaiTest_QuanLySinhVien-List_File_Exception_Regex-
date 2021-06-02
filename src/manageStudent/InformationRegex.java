package manageStudent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InformationRegex {
    public static final String DATE_OF_BIRTH = "^[0-3][0-9][-][0-1][0-2][-][0-9]{4}$";
    public static final String EMAIL = "^[a-z]{1,}.[a-z]{1,}@codegym.vn$";
    public static final String ID = "^C[1-9]{4}[GHIK][1-9]{2}$";

    public InformationRegex() {
    }

    public static boolean validateDate(String date) {
        Pattern pattern = Pattern.compile(DATE_OF_BIRTH);
        Matcher matcher = pattern.matcher(date);
        return matcher.matches();
    }

    public static boolean validateEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    public static boolean validateID(String id) {
        Pattern pattern = Pattern.compile(ID);
        Matcher matcher = pattern.matcher(id);
        return matcher.matches();
    }
}
