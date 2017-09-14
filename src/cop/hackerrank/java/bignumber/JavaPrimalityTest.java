package cop.hackerrank.java.bignumber;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 14.09.2017
 */
public class JavaPrimalityTest {
    public static void main(String... args) {
        Scanner in = new Scanner(System.in);
        BigInteger n = in.nextBigInteger();
        in.close();

        System.out.println(n.isProbablePrime(3) ? "prime" : "not prime");
    }
}
