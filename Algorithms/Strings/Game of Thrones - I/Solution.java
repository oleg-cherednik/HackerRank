import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 13.07.2018
 */
public class Solution {

    static String gameOfThrones(String s) {
        int[] arr = new int[26];

        for (int i = 0; i < s.length(); i++)
            arr[s.charAt(i) - 'a']++;

        boolean mid = false;

        for (int v : arr) {
            if (v % 2 == 0)
                continue;
            if (mid)
                return "NO";

            mid = true;
        }

        return "YES";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String s = scanner.nextLine();

        String result = gameOfThrones(s);
        System.out.println(result);

        scanner.close();
    }
}
