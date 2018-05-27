import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 20.05.2018
 */
public class Solution {

private static boolean isPrime(int n) {
    if (n < 2)
        return false;
    for (int i = 2, max = (int)Math.sqrt(n); i <= max; i++)
        if (n % i == 0)
            return false;
    return true;
}

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int p = scanner.nextInt();

        for (int pItr = 0; pItr < p; pItr++) {
            int n = scanner.nextInt();
            System.out.println(isPrime(n) ? "Prime" : "Not prime");
        }

        scanner.close();
    }

}
