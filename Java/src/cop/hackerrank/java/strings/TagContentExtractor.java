package cop.hackerrank.java.strings;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <h1>Tag Content Extractor</h1>
 * In a tag-based language like <tt>XML</tt> or <tt>HTML</tt>, contents are enclosed between a <tt>start tag</tt> and an <tt>end tag</tt> like
 * <tt>{@literal <tag>contents</tag>}</tt>. Note that the corresponding <tt>end tag</tt> starts with a <tt>/</tt>.
 * </p>
 * Given a string of text in a tag-based language, parse this text and retrieve the contents enclosed within sequences of well-organized tags meeting
 * the following criterion:
 * <ol>
 * <li>The name of the <tt>start</tt> and <tt>end</tt> tags must be same. The HTML code <tt>{@literal <h1>Hello World</h2>}</tt> is <tt>not
 * valid</tt>, because the text starts with an <tt>h1</tt> tag and ends with a non-matching <tt>h2</tt> tag.</li>
 * <li>Tags can be nested, but content between nested tags is considered <tt>not valid</tt>. For example, in <tt>{@literal
 * <h1><a>contents</a>invalid</h1>}</tt>, <tt>contents</tt> is <tt>valid</tt> but <tt>invalid</tt> is
 * not <tt>valid</tt>.</li>
 * <li>Tags can consist of any printable characters.</li>
 * </ol>
 * <h3>Input Format</h3>
 * The first line of input contains a single integer, N (the number of lines).<br>
 * The N subsequent lines each contain a line of text.
 * <h3>Constraints</h3>
 * <ul>
 * <li>1 <= N <= 100</li>
 * <li>Each line contains a maximum of 10<sup>4</sup> printable characters.</li>
 * <li>The total number of characters in all test cases will not exceed 10<sup>6</sup>.</li>
 * </ul>
 * <h3>Output Format</h3>
 * For each line, print the content enclosed within valid tags.<br>
 * If a line contains multiple instances of valid content, print out each instance of valid content on a new line; if no valid content is found,
 * print
 * <tt>None</tt>.
 * <h3>Sample Input</h3>
 * <pre>
 *  4
 * {@literal <h1>Nayeem loves counseling</h1>}
 * {@literal <h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>}
 * {@literal <Amee>safat codes like a ninja</amee>}
 * {@literal <SA premium>Imtiaz has a secret crush</SA premium>}
 * </pre>
 * <h3>Sample Output</h3>
 * <pre>
 * Nayeem loves counseling
 * Sanjay has no watch
 * So wait for a while
 * None
 * Imtiaz has a secret crush
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 14.09.2017
 */
public class TagContentExtractor {
    public static void main(String... args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        Pattern pattern = Pattern.compile("(?:<([^<>]+)>([^<>]+)<\\/([^<>]+)>)");
        while (testCases > 0) {
            String line = in.nextLine();
            Matcher matcher = pattern.matcher(line);
            boolean find = matcher.find();

            if (find) {
                find = false;

                do {
                    String openTag = matcher.group(1);
                    String text = matcher.group(2);
                    String closeTag = matcher.group(3);

                    if (openTag.equals(closeTag)) {
                        find = true;
                        System.out.println(text);
                    }

                    if (matcher.start() + 1 >= line.length())
                        break;
                } while (matcher.find(matcher.start() + 1));

                if (!find)
                    System.out.println("None");
            } else
                System.out.println("None");

            testCases--;
        }
    }
}
