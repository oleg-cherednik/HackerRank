import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 13.07.2018
 */
public class Solution {

    static int alternatingCharacters(String s) {
        int res = 0;

        for (int i = 0, j = i + 1; j < s.length(); i++, j++)
            if (s.charAt(i) == s.charAt(j))
                res++;

        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = alternatingCharacters(s);
            System.out.println(String.valueOf(result));
        }

        scanner.close();
    }
}
