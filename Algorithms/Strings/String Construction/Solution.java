import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 13.07.2018
 */
public class Solution {

    static int stringConstruction(String s) {
        int unique = 0;

        for (int i = 0; i < s.length(); i++)
            if (s.lastIndexOf(s.charAt(i)) == i)
                unique++;

        return unique;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = stringConstruction(s);
            System.out.println(String.valueOf(result));
        }

        scanner.close();
    }
}
