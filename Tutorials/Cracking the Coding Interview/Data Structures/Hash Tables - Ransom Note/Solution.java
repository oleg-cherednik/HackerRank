import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 15.05.2018
 */
public class Solution {

    private static String isRansomNote(String[] magazineItems, String[] ransomItems) {
        Map<String, Integer> map = new HashMap<>();

        for (String magazineItem : magazineItems)
            map.put(magazineItem, map.getOrDefault(magazineItem, 0) + 1);

        for (String ransomItem : ransomItems) {
            if (map.containsKey(ransomItem)) {
                int count = map.remove(ransomItem) - 1;

                if (count > 0)
                    map.put(ransomItem, count);
            } else
                return "No";
        }

        return "Yes";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] ransom = new String[n];

        String[] ransomItems = scanner.nextLine().split(" ");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String ransomItem = ransomItems[i];
            ransom[i] = ransomItem;
        }

        System.out.println(isRansomNote(magazineItems, ransomItems));

        scanner.close();
    }

}
