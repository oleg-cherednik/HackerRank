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

        Pattern pattern = Pattern.compile("^(?<country>\\d+)[\\s-](?<local>\\d+)[\\s-](?<number>\\d+)$");
        scan.nextLine();

        for (int i = 0; i < N; i++) {
            Matcher matcher = pattern.matcher(scan.nextLine());

            if (matcher.matches())
                System.out.format("CountryCode=%s,LocalAreaCode=%s,Number=%s\n",
                        matcher.group("country"), matcher.group("local"), matcher.group("number"));
        }

        scan.close();
    }
}
