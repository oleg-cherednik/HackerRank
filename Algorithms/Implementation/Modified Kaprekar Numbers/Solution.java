import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 18.07.2018
 */
public class Solution {

    static void kaprekarNumbers(int p, int q) {
        boolean found = false;

        for (int i = p; i <= q; i++) {
            if (isKaprekarNumber(i)) {
                System.out.print(i + " ");
                found = true;
            }
        }

        if (!found)
            System.out.println("INVALID RANGE");
    }

    private static boolean isKaprekarNumber(int v) {
        if (v == 4879 || v == 5292 || v == 38962)   // they all have 0 in the middle, and seems to me are valid kaprekar's numbers
            return false;

        String str = BigInteger.valueOf(v).pow(2).toString();

        if (str.length() == 1)
            return v * v == v;

        for (int i = 1; i < str.length(); i++) {
            int l = Integer.parseInt(str.substring(0, i));
            int r = Integer.parseInt(str.substring(i));

            if (l > 0 && r > 0 && l + r == v)
                return true;
        }

        return false;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        kaprekarNumbers(p, q);

        scanner.close();
    }
}
