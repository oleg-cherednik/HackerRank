package cop.hackerrank.java.strings;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * @author Oleg Cherednik
 * @since 14.09.2017
 */
public class PatternSyntaxChecker {
    public static void main(String... args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while (testCases > 0) {
            try {
                Pattern.compile(in.nextLine());
                System.out.println("Valid");
            } catch(PatternSyntaxException ignored) {
                System.out.println("Invalid");
            }

            testCases++;
        }
    }
}
