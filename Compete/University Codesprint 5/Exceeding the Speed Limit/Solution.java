import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 08.09.2018
 */
public class Solution {

    static void solve(int s) {
        if (s <= 90)
            System.out.println("0 sNo punishment");
        else if (s <= 110)
            System.out.println((s - 90) * 300 + " Warning");
        else
            System.out.println((s - 90) * 500 + " License removed");
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int s = scan.nextInt();
        solve(s);
    }
}
