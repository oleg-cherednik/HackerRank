import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 14.08.2018
 */
public class Solution {

    static int gameWithCells(int n, int m) {
        return (int)Math.ceil(n / 2.) * (int)Math.ceil(m / 2.);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0].trim());

        int m = Integer.parseInt(nm[1].trim());

        int result = gameWithCells(n, m);

        System.out.println(String.valueOf(result));
    }

}
