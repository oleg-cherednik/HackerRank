import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 07.06.2018
 */
public class Solution {

    private static boolean isPrime(int val) {
        if (val < 2)
            return false;

        for (int i = 2, sqrt = (int)Math.sqrt(val); i <= sqrt; i++)
            if (val % i == 0)
                return false;

        return true;
    }

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            int T = scan.nextInt();

            for (int i = 0; i < T; i++)
                System.out.println(isPrime(scan.nextInt()) ? "Prime" : "Not prime");
        }
    }

}

