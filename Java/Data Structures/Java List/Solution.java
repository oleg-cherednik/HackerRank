import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 18.09.2017
 */
public class Solution {
    public static void main(String... args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> data = new ArrayList<>();
        int n = scan.nextInt();

        for (int i = 0; i < n; i++)
            data.add(scan.nextInt());

        int q = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < q; i++) {
            String cmd = scan.next();

            if ("Insert".equalsIgnoreCase(cmd))
                data.add(scan.nextInt(), scan.nextInt());
            else if ("Delete".equalsIgnoreCase(cmd))
                data.remove(scan.nextInt());

            scan.nextLine();
        }

        boolean space = false;

        for (int val : data) {
            if (space)
                System.out.print(" ");
            System.out.print(val);
            space = true;
        }
    }
}
