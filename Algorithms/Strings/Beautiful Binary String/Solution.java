import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author Oleg Cherednik
 * @since 11.07.2018
 */
public class Solution {

    private static final Pattern SUBSTR = Pattern.compile("010");

    static int beautifulBinaryString(String b) {
        return (b.length() - SUBSTR.matcher(b).replaceAll("").length()) / 3;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String b = scanner.nextLine();

        int result = beautifulBinaryString(b);
        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
