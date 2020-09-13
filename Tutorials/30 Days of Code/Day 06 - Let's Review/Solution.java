import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 18.05.2018
 */
public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();

        scan.nextLine();

        for (int i = 0; i < T; i++) {
            String str = scan.nextLine();
            StringBuilder even = new StringBuilder(str.length());
            StringBuilder odd = new StringBuilder(str.length());

            for (int j = 0; j < str.length(); j++)
                (j % 2 == 0 ? even : odd).append(str.charAt(j));

            System.out.println(even + " " + odd);
        }
    }
}
