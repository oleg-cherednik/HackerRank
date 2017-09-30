import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 12.09.2017
 */
public class Solution {
    public static String getDay(String day, String month, String year) {
        Calendar cal = Calendar.getInstance(Locale.US);
        cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(day));
        cal.set(Calendar.MONTH, Integer.parseInt(month) - 1);
        cal.set(Calendar.YEAR, Integer.parseInt(year));
        return new SimpleDateFormat("EEEE", Locale.US).format(cal.getTime()).toUpperCase();
    }

    public static void main(String... args) {
        Scanner in = new Scanner(System.in);
        String month = in.next();
        String day = in.next();
        String year = in.next();

        System.out.println(getDay(day, month, year));
    }
}
