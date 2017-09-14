package cop.hackerrank.java.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Oleg Cherednik
 * @since 14.09.2017
 */
public class TagContentExtractor {
    public static void main(String... args) {
        String str = "<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>";
        Pattern pattern = Pattern.compile("");

        Matcher matcher = pattern.matcher(str);

    }
}
