import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 17.05.2018
 */
public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();

        for (int i = 1; i <= 10; i++)
            System.out.println(n + " x " + i + " = " + (n * i));

        scanner.close();
    }
}
