import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 13.07.2018
 */
public class Solution {

    static int palindromeIndex(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) == s.charAt(j))
                continue;

            for (int k = i, m = j - 1; k < m; k++, m--)
                if (s.charAt(k) != s.charAt(m))
                    return i;

            return j;
        }

        return -1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = palindromeIndex(s);
            System.out.println(String.valueOf(result));
        }

        scanner.close();
    }
}
