import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 11.07.2018
 */
public class Solution {

    static int anagram(String s) {
        if (s.isEmpty() || s.length() % 2 != 0)
            return -1;

        int[] arr = new int[26];
        int mid = s.length() / 2;

        for (int i = 0; i < s.length(); i++) {
            if (i < mid)
                arr[s.charAt(i) - 'a']--;
            else
                arr[s.charAt(i) - 'a']++;
        }

        int res = 0;

        for (int count : arr)
            if (count > 0)
                res += count;

        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = anagram(s);
            System.out.println(String.valueOf(result));
        }

        scanner.close();
    }
}
