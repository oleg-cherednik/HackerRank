import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 13.07.2018
 */
public class Solution {

    static String hackerrankInString(String s) {
        final String str = "hackerrank";
        int j = 0;

        for (int i = 0; i < s.length() && j < str.length(); i++)
            if (s.charAt(i) == str.charAt(j))
                j++;

        return j == str.length() ? "YES" : "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            String result = hackerrankInString(s);
            System.out.println(result);
        }

        scanner.close();
    }
}
