import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
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

        Pattern pattern = Pattern.compile("https?:\\/\\/(?<domain>[A-Za-z\\d-]+(?:\\.[A-Za-z\\d-]+)*\\.[A-Za-z]+)");
        scan.nextLine();
        Set<String> domains = new TreeSet<>();

        for (int i = 0; i < N; i++) {
            String str = scan.nextLine();
            Matcher matcher = pattern.matcher(str);

            while (matcher.find()) {
                String domain = matcher.group("domain");
                domains.add(domain.startsWith("www.") || domain.startsWith("ww2.") ? domain.substring(4) : domain);
            }
        }

        boolean sep = false;

        for (String email : domains) {
            if (sep)
                System.out.print(';');
            System.out.print(email);
            sep = true;
        }

        scan.close();
    }
}
