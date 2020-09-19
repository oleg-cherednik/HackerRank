import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 09.08.2018
 */
public class Solution {

    static int findDigitSum(int N) {
        BigInteger val = BigInteger.ONE;

        for (int i = 2; i <= N; i++)
            val = val.multiply(BigInteger.valueOf(i));

        String str = String.valueOf(val);
        int res = 0;

        for (int i = 0; i < str.length(); i++)
            res += str.charAt(i) - '0';

        return res;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();

        for (int i = 0; i < T; i++)
            System.out.println(findDigitSum(scan.nextInt()));
    }

}
