import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 10.06.2018
 */
public class Solution {

    private static String appendAndDelete(String s, String t, int k) {
        int sum = s.length() + t.length();
        int length = 0;

        for (int i = 0, min = Math.min(s.length(), t.length()); i < min && s.charAt(i) == t.charAt(i); i++)
            length++;

        length *= 2;

        if (sum - length > k)
            return "No";
        if ((sum - length) % 2 == k % 2)
            return "Yes";
        return sum - k < 0 ? "Yes" : "No";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String s = scanner.nextLine();

        String t = scanner.nextLine();

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = appendAndDelete(s, t, k);

        System.out.println(result);

        scanner.close();
    }
}
