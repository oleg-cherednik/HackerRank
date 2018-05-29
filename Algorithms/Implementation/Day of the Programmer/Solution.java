import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 29.05.2018
 */
public class Solution {

    static String solve(int year) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setGregorianChange(new Date(-1637193600000L));
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.DAY_OF_YEAR, 256);
        return String.format("%02d.%02d.%04d", cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.MONTH) + 1, year);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int year = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = solve(year);
        System.out.println(result);

        scanner.close();
    }
}
