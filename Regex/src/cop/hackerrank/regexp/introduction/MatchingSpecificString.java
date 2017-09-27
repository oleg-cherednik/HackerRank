package cop.hackerrank.regexp.introduction;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <h1>Matching Specific String</h1>
 * <h3><a href="https://en.wikipedia.org/wiki/Regular_expression">Regular expression</a> (or RegEx)</h3>
 * A regular expression is a sequence of characters that define a search pattern. It is mainly used for string pattern matching.
 * <pre>
 * <img src="image1.png"/>
 * In the above image, a Regex Pattern is matched with the Test String.
 * </pre>
 * Regular expressions are extremely useful in extracting information from text such as: code, log files, spreadsheets, documents, etc.
 * <p>
 * We can match a specific string <tt>X</tt> in a test string <tt>S</tt> by making our regex pattern <tt>X</tt>. This is one of the simplest patterns.
 * However, in the coming challenges, we'll see how well we can match more complex patterns and learn about their syntax.
 * <h3>Task</h3>
 * You have a test string <tt>S</tt>. Your task is to match the string <tt>hackerrank</tt>. This is case sensitive.
 * <h3>Note</h3>
 * This is a regex only challenge. You are not required to write code.<br>
 * You only have to fill in the regex pattern in the blank (<tt>_________</tt>).
 *
 * @author Oleg Cherednik
 * @since 28.09.2017
 */
public class MatchingSpecificString {
    public static void main(String... args) {
        Regex_Test tester = new Regex_Test();
        tester.checker("hackerrank");
    }

    static class Regex_Test {
        public void checker(String Regex_Pattern) {
            Scanner Input = new Scanner(System.in);
            String Test_String = Input.nextLine();
            Pattern p = Pattern.compile(Regex_Pattern);
            Matcher m = p.matcher(Test_String);
            int Count = 0;
            while (m.find()) {
                Count += 1;
            }
            System.out.format("Number of matches : %d", Count);
        }
    }
}
