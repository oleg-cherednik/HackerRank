import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 31.05.2018
 */
public class Solution {

    static int countingValleys(int n, String s) {
        int level = 0;
        int prvLevel;
        int count = 0;


        for (int i = 0; i < s.length(); i++) {
            prvLevel = level;

            if (s.charAt(i) == 'D')
                level--;
            else if (s.charAt(i) == 'U')
                level++;

            if (level == 0 && prvLevel < 0)
                count++;
        }

        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
