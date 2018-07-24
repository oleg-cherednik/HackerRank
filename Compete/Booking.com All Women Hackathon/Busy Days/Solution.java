import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @author Oleg Cherednik
 * @since 21.07.2018
 */
public class Solution {

    static String solve(List<List<String>> reservations) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        ZonedDateTime start = zonedDateTime("2018-01-01", df);
        int[] days = new int[daysBetween(start, zonedDateTime("2020-12-31", df).plusDays(1))];

        reservations.forEach(range -> {
            Iterator<String> it = range.iterator();
            ZonedDateTime d0 = zonedDateTime(it.next(), df);
            ZonedDateTime d1 = zonedDateTime(it.next(), df);

            int offs = daysBetween(start, d0);
            int total = daysBetween(d0, d1.plusDays(1));

            for (int i = 0; i < total; i++)
                days[offs + i]++;
        });

        int j = 0;

        for (int i = 0; i < days.length; i++)
            if (days[i] > days[j])
                j = i;

        return df.format(start.plusDays(j));
    }

    private static ZonedDateTime zonedDateTime(String str, DateTimeFormatter df) {
        return LocalDate.parse(str, df).atStartOfDay(ZoneOffset.UTC);
    }

    private static int daysBetween(ZonedDateTime date1, ZonedDateTime date2) {
        return (int)Math.abs(Duration.between(date1, date2).toDays());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            int n = Integer.parseInt(scanner.nextLine().trim());

            List<List<String>> reservations = new ArrayList<>();

            IntStream.range(0, n).forEach(i -> {
                reservations.add(Stream.of(scanner.nextLine().replaceAll("\\s+$", "").split(" ")).collect(toList())
                );
            });

            String result = solve(reservations);

            System.out.println(result);
        });
    }
}
