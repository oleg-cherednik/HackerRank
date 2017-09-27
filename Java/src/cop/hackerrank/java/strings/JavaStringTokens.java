package cop.hackerrank.java.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 13.09.2017
 */
public class JavaStringTokens {
    public static void main(String... args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        List<String> tokens = new ArrayList<>();
        char[] arr = s.toCharArray();
        StringBuilder buf = new StringBuilder();

        for (char ch : arr) {
            if (ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z')
                buf.append(ch);
            else if (buf.length() > 0) {
                tokens.add(buf.toString());
                buf.setLength(0);
            }
        }

        if (buf.length() > 0)
            tokens.add(buf.toString());

        System.out.println(tokens.size());

        for (String token : tokens)
            System.out.println(token);

        scan.close();
    }
}
