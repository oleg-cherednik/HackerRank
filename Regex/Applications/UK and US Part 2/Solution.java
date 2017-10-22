import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author Oleg Cherednik
 * @since 22.10.2017
 */
public class Solution {
    private static final Pattern OR = Pattern.compile("or");

    public static void main(String... args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        scan.nextLine();
        Map<String, Integer> words = new HashMap<>();

        for (int i = 0; i < N; i++) {
            for (String word : scan.nextLine().split(" ")) {
                if (word.contains("or"))
                    word = OR.matcher(word).replaceAll("our");
                if (!words.containsKey(word))
                    words.put(word, 0);
                words.put(word, words.get(word) + 1);
            }
        }

        int T = scan.nextInt();

        scan.nextLine();

        for (int i = 0; i < T; i++) {
            String word = scan.nextLine();
            int total = 0;

            if (words.containsKey(word))
                total = words.get(word);

            System.out.println(total);
        }

        scan.close();
    }
}
