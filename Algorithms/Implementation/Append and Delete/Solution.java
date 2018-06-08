import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 07.06.2018
 */
public class Solution {

    static String appendAndDelete(String s, String t, int k) {
        int max = Math.max(s.length(), t.length());
        int min = Math.min(s.length(), t.length());
        int i = 0;

        while (i < min && s.charAt(i) == t.charAt(i)) {
            i++;
        }

        int total = i < max ? Math.abs(s.length() - t.length()) + 2 * (min - i) : 0;
        return total <= k && (k - total) % 2 == 0 ? "Yes" : "No";
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
