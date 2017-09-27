package cop.hackerrank.regexp.introduction;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <h1>Matching Anything But a Newline</h1>
 * <h3><a href="http://www.regular-expressions.info/dot.html">dot</a></h3>
 * The dot (<tt>.</tt>) matches anything (except for a newline).
 * <pre>
 * <img src="image2.png"/>
 * In the above image, a Regex Pattern is matched with the Test String.
 * </pre>
 * <b>Note:</b> If you want to match (<tt>.</tt>) in the test string, you need to escape the dot by using a slash <tt>\..</tt><br>
 * In Java, use <tt>\\.</tt> instead of <tt>\.</tt>.
 * <h3>Task</h3>
 * You have a test string <tt>S</tt>.<br>
 * Your task is to write a regular expression that matches only and exactly strings of form: <tt>abc.def.ghi.jkx</tt>, where each variable
 * <tt>a,b,c,d,e,f,g,h,i,j,k,x</tt> can be any single character except the newline.
 * <h3>Note</h3>
 * This is a regex only challenge. You are not required to write any code.<br>
 * You only have to fill in the regex pattern in the blank (<tt>_________</tt>).
 *
 * @author Oleg Cherednik
 * @since 28.09.2017
 */
public class MatchingAnythingButANewline {
    public static void main(String... args) {
        Tester tester = new Tester();
        tester.check("(?:[^\n]{3}\\.){3}[^\n]{3}");
    }

    static class Tester {
        public void check(String pattern) {
            Scanner scanner = new Scanner(System.in);
            String testString = scanner.nextLine();
            Pattern p = Pattern.compile(pattern);
            Matcher m = p.matcher(testString);
            boolean match = m.matches();
            System.out.format("%s", match);
        }
    }
}
