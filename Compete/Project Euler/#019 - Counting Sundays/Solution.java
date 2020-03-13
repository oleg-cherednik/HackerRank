import java.time.DayOfWeek;
import java.util.Scanner;

/**
 * Zeller's congruence
 *
 * @author Oleg Cherednik
 * @since 13.03.2020
 */
public class Solution {

    private static int countSundays(long y1, int m1, int d1, long y2, int m2, int d2) {
        int res = 0;

        if (d1 != 1) {
            d1 = 1;

            if (m1 == 12) {
                m1 = 1;
                y1++;
            } else
                m1++;
        }

        for (; y1 <= y2; y1++, m1 = 1)
            for (; y1 == y2 ? m1 <= m2 : m1 <= 12; m1++)
                if (zeller(y1, m1, d1) == DayOfWeek.SUNDAY)
                    res++;

        return res;
    }

    private static final DayOfWeek[] DAY_OF_WEEK = { DayOfWeek.SATURDAY, DayOfWeek.SUNDAY, DayOfWeek.MONDAY,
            DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY, DayOfWeek.FRIDAY };

    private static DayOfWeek zeller(long year, final int month, int day) {
        int m = month < 3 ? month + 12 : month;
        long y = month < 3 ? year - 1 : year;
        int h = (int)((day + ((m + 1) * 13) / 5 + y + y / 4 - y / 100 + y / 400) % 7);
        return DAY_OF_WEEK[h];
    }

    public static void main(String... args) {
        try (Scanner scan = new Scanner(System.in)) {
            int T = scan.nextInt();

            for (int i = 0; i < T; i++) {
                long y1 = scan.nextLong();
                int m1 = scan.nextInt();
                int d1 = scan.nextInt();
                long y2 = scan.nextLong();
                int m2 = scan.nextInt();
                int d2 = scan.nextInt();

                System.out.println(countSundays(y1, m1, d1, y2, m2, d2));
            }
        }
    }

}
