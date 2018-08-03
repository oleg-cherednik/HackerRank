import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 04.07.2018
 */
public class Solution {

    static int superDigit(String n, int k) {
        if (n.length() == 1)
            return n.charAt(0) - '0';

        long sum = 0;

        for (int i = 0; i < n.length(); i++)
            sum += n.charAt(i) - '0';

        sum *= k;

        return superDigit(String.valueOf(sum), 1);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nk = scanner.nextLine().split(" ");

        String n = nk[0];

        int k = Integer.parseInt(nk[1]);

        int result = superDigit(n, k);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
