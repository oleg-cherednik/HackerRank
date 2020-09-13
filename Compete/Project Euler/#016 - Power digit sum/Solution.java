import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 20.07.2018
 */
public class Solution {

    static long powerDigitSum(int n) {
        String str = BigInteger.valueOf(2).pow(n).toString();

        int sum = 0;

        for (int i = 0; i < str.length(); i++)
            sum += str.charAt(i) - '0';

        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            System.out.println(powerDigitSum(n));
        }
    }

//    public static void main(String... args) {
//        System.out.println(powerDigitSum(1_000));   // 1366
//    }

}
