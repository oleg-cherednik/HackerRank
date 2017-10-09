import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Oleg Cherednik
 * @since 09.10.2017
 */
public class Solution {
    public static void main(String... args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        Pattern pattern = Pattern.compile("<(?<tag>\\w+)[^>]*>");

        scan.nextLine();

        Set<String> tags = new TreeSet<>();

        for (int i = 0; i < N; i++) {
            String str = scan.nextLine();
            Matcher matcher = pattern.matcher(str);
            int start = 0;

            while (matcher.find(start)) {
                tags.add(matcher.group("tag"));
                start = matcher.start() + 1;
            }
        }

        boolean semicolon = false;

        for (String tag : tags) {
            if (semicolon)
                System.out.print(';');
            System.out.print(tag);
            semicolon = true;
        }

        scan.close();
    }
}
