import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 29.05.2018
 */
public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] bill = new int[n];

        for (int i = 0; i < bill.length; i++)
            bill[i] = scan.nextInt();

        int b = scan.nextInt();

        int actual = (Arrays.stream(bill).sum() - bill[k]) / 2;

        if (b > actual)
            System.out.println(b - actual);
        else
            System.out.println("Bon Appetit");
    }
}
