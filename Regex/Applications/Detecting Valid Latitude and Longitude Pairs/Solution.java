import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Oleg Cherednik
 * @since 22.10.2017
 */
public class Solution {

    public static void main(String... args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        scan.nextLine();
        Pattern pattern = Pattern.compile("^\\((?<latitude>[+-]?[1-9]\\d*(?:\\.\\d+)?), (?<longitude>[+-]?[1-9]\\d*(?:\\.\\d+)?)\\)$");

        for (int i = 0; i < N; i++) {
            String str = scan.nextLine();
            Matcher matcher = pattern.matcher(str);

            if (matcher.matches()) {
                double lat = Double.parseDouble(matcher.group("latitude"));
                double lon = Double.parseDouble(matcher.group("longitude"));

                if (Double.compare(lat, -90) >= 0 && Double.compare(lat, 90) <= 0
                        && Double.compare(lon, -180) >= 0 && Double.compare(lon, 180) <= 0)
                    System.out.println("Valid");
                else
                    System.out.println("Invalid");
            } else
                System.out.println("Invalid");
        }

        scan.close();
    }
}
