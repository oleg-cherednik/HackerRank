import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 22.10.2017
 */
public class Solution {

    public static void main(String... args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        scan.nextLine();

        for (int i = 0; i < N; i++) {
            String str = scan.nextLine().toLowerCase();
            boolean start = str.startsWith("hackerrank");
            boolean end = str.endsWith("hackerrank");

            if (start)
                System.out.println(end ? 0 : 1);
            else
                System.out.println(end ? 2 : -1);
        }

        scan.close();
    }
}
