import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Oleg Cherednik
 * @since 10.09.2018
 */
public class Solution {

    static int getNameScore(String name, Map<String, Integer> names) {
        int res = 0;

        for (int i = 0; i < name.length(); i++)
            res += name.charAt(i) - 'a' + 1;

        return res * names.get(name);
    }

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            int N = scan.nextInt();
            Set<String> names = new TreeSet<>();

            for (int i = 0; i < N; i++)
                names.add(scan.next().toLowerCase());

            int i = 1;
            Map<String, Integer> map = new HashMap<>();

            for (String name : names)
                map.put(name, i++);

            int Q = scan.nextInt();

            for (i = 0; i < Q; i++)
                System.out.println(getNameScore(scan.next().toLowerCase(), map));
        }
    }
}
