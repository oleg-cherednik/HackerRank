import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Oleg Cherednik
 * @since 28.09.2017
 */
public class Solution {
    public static void main(String... args) {
        Tester tester = new Tester();
        tester.check("(?:[^\n]{3}\\.){3}[^\n]{3}");
    }
}

class Tester {
    public void check(String pattern) {
        Scanner scanner = new Scanner(System.in);
        String testString = scanner.nextLine();
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(testString);
        boolean match = m.matches();
        System.out.format("%s", match);
    }
}
