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
        int N = scan.nextInt();
        String[] sentences = new String[N];

        scan.nextLine();

        for (int i = 0; i < N; i++) {
            sentences[i] = scan.nextLine();
        }

        int T = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < T; i++) {
            Pattern pattern = Pattern.compile("(?<![A-za-z\\d_])" + scan.nextLine() + "(?![A-za-z\\d_])");

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
