import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 27.10.2017
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        scan.nextLine();

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String str = scan.nextLine();

            if (!map.containsKey(str))
                map.put(str, 0);
            map.put(str, map.get(str) + 1);
        }

        int Q = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < Q; i++) {
            Integer total = map.get(scan.nextLine());
            System.out.println(total != null ? total : 0);
        }

        scan.close();
    }
}
