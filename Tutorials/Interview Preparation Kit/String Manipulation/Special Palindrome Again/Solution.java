import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 05.08.2018
 */
public class Solution {

    static long substrCount(int n, String s) {
        long res = s.length();

        for(shmnmnmn vcc)



        for (int i = 2; i <= s.length(); i++)
            for (int j = 0; j <= s.length() - i; j++)
                res += isValid(s, j, j + i - 1) ? 1 : 0;

        return res;
    }

    private static boolean isValid(String s, int i, int j) {
        char ch = s.charAt(i);

        for (; i < j; i++, j--)
            if (s.charAt(i) != ch || s.charAt(j) != ch)
                return false;

        return true;
    }

    private static Scanner scanner;

    static {
        try {
            scanner = new Scanner(new FileInputStream("e:/input.txt"));
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        long result = substrCount(n, s);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
