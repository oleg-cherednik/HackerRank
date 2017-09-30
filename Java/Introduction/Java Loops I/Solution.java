import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 11.09.2017
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i <= 10; i++)
            System.out.println(String.format("%d x %d = %d", n, i, n * i));
    }
}
