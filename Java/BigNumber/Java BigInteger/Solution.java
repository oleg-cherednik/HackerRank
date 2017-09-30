import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 14.09.2017
 */
public class Solution {
    public static void main(String... args) {
        Scanner scan = new Scanner(System.in);
        BigInteger a = scan.nextBigInteger();
        BigInteger b = scan.nextBigInteger();
        scan.close();

        System.out.println(a.add(b));
        System.out.println(a.multiply(b));
    }
}
