import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 13.07.2018
 */
public class Solution {

    static String funnyString(String s) {
        for (int i = 0, j = s.length() - 1; j > 0; i++, j--)
            if (Math.abs(s.charAt(i + 1) - s.charAt(i)) != Math.abs(s.charAt(j) - s.charAt(j - 1)))
                return "Not Funny";

        return "Funny";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            String result = funnyString(s);
            System.out.println(result);
        }

        scanner.close();
    }
}
