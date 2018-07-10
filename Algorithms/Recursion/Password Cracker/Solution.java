import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 08.07.2018
 */
public class Solution {

    private static final String WRONG_PASSWORD = "WRONG PASSWORD";

    static String passwordCracker(String[] pass, String attempt) {
        int pos = attempt.lastIndexOf(' ');

        if (pos < 0)
            Arrays.sort(pass, Collections.reverseOrder());

        for (int i = 0; i < pass.length; i++) {
            String str = pass[i];

            if (attempt.startsWith(str, pos + 1)) {
                int end = pos + str.length() + 1;

                if (end == attempt.length())
                    return attempt;

                String res = passwordCracker(pass, attempt.substring(0, end) + ' ' + attempt.substring(end));

                if (!WRONG_PASSWORD.equals(res))
                    return res;

                int a = 0;
                a++;
            }
        }

        return WRONG_PASSWORD;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            String[] pass = new String[n];
            for (int pass_i = 0; pass_i < n; pass_i++) {
                pass[pass_i] = in.next();
            }
            String attempt = in.next();
            String result = passwordCracker(pass, attempt);
            System.out.println(result);
        }
        in.close();
    }
}
