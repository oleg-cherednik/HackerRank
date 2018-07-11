import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 11.07.2018
 */
public class Solution {

    static String twoStrings(String s1, String s2) {
        int[] arr = new int[26];

        for (int i = 0; i < s1.length(); i++)
            arr[s1.charAt(i) - 'a']++;

        for (int i = 0; i < s2.length(); i++)
            if (arr[s2.charAt(i) - 'a'] > 0)
                return "YES";

        return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);
            System.out.println(result);
        }

        scanner.close();
    }
}
