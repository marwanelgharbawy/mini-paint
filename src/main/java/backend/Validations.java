package backend;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Validations {
    public static boolean isNumberValid(String number){
        String pattern = "^[0-9]+$";
        return number.matches(pattern);
    }
}
