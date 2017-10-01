import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Oleg Cherednik
 * @since 14.09.2017
 */
public class Solution {
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
