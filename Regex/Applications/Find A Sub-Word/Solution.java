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
        String[] sentences = new String[n];

        scan.nextLine();

        for (int i = 0; i < n; i++) {
            sentences[i] = scan.nextLine();
        }

        int q = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < q; i++) {
            Pattern pattern = Pattern.compile("(?:\\w(" + scan.nextLine() + ")\\w)");

            int total = 0;

            for (String sentence : sentences) {
                Matcher matcher = pattern.matcher(sentence);

                while (matcher.find()) {
                    total++;
                }
            }

            System.out.println(total);
        }

        scan.close();
    }
}
