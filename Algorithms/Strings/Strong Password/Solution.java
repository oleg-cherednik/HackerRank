import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author Oleg Cherednik
 * @since 11.07.2018
 */
public class Solution {

    private static final Pattern DIGIT = Pattern.compile(".*\\d.*");
    private static final Pattern LOWER_CASE = Pattern.compile(".*[a-z].*");
    private static final Pattern UPPER_CASE = Pattern.compile(".*[A-Z].*");
    private static final Pattern SPECIAL_CHARACTER = Pattern.compile(".*[!@#$%^&*\\(\\)\\-+].*");

    static int minimumNumber(int n, String password) {
        int res = 0;

        if (!DIGIT.matcher(password).matches())
            res++;
        if (!LOWER_CASE.matcher(password).matches())
            res++;
        if (!UPPER_CASE.matcher(password).matches())
            res++;
        if (!SPECIAL_CHARACTER.matcher(password).matches())
            res++;

        return Math.max(6 - password.length(), res);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String password = scanner.nextLine();

        int answer = minimumNumber(n, password);
        System.out.println(String.valueOf(answer));

        scanner.close();
    }
}
