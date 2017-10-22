import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Oleg Cherednik
 * @since 21.10.2017
 */
public class Solution {

    public static void main(String... args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Pattern IPv4 = Pattern.compile("(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})");
        Pattern IPv6 = Pattern.compile("([\\da-f]{1,4})\\:([\\da-f]{1,4})\\:([\\da-f]{1,4})\\:"
                + "([\\da-f]{1,4})\\:([\\da-f]{1,4})\\:([\\da-f]{1,4})\\:([\\da-f]{1,4})\\:([\\da-f]{1,4})");
        scan.nextLine();

        for (int i = 0; i < n; i++) {
            String str = scan.nextLine().trim();
            Matcher matcher = IPv4.matcher(str);

            if (matcher.matches()) {
                boolean match = true;

                for (int j = 1; j <= 4; j++) {
                    int val = Integer.parseInt(matcher.group(j));

                    if (val < 0 || val > 255)
                        match = false;
                }

                System.out.println(match ? "IPv4" : "Neither");
                continue;
            }

            System.out.println(IPv6.matcher(str).matches() ? "IPv6" : "Neither");
        }

        scan.close();
    }
}
