import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Oleg Cherednik
 * @since 08.10.2017
 */
public class Solution {
    public static void main(String... args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        Pattern pattern = Pattern.compile("<a href=\"(?<link>[^\"]*)\"[^>]*>(?:<[^>]+>)*(?<text>[^<]*)(?:<\\/[^<]+>)*<\\/a>");

        scan.nextLine();

        for (int i = 0; i < N; i++) {
            String str = scan.nextLine();
            Matcher matcher = pattern.matcher(str);
            int start = 0;

            while(matcher.find(start)) {
                System.out.format("%s,%s\n", matcher.group("link"), matcher.group("text").trim());
                start = matcher.start() + 1;
            }
        }

        scan.close();
    }
}
