import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 07.01.2019
 */
public class Solution {

    private static final class Group {

        private final char ch;
        private int length = 1;

        private Group(char ch) {
            this.ch = ch;
        }
    }

    static long substrCount(int n, String s) {
        if (s.isEmpty())
            return 0;

        List<Group> groups = getGroups(s);
        long res = 0;

        for (int i = 0; i < groups.size(); i++) {
            Group group = groups.get(i);
            res += countSingleCharGroup(group.length);

            if (i > 1) {
                Group prvGroup = groups.get(i - 1);

                if (prvGroup.length == 1) {
                    prvGroup = groups.get(i - 2);
                    res += prvGroup.ch == group.ch ? Math.min(group.length, prvGroup.length) : 0;
                }
            }
        }

        return res;
    }

    private static List<Group> getGroups(String str) {
        List<Group> groups = new ArrayList<>();
        char prv = '\0';

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (i == 0 || ch != prv)
                groups.add(new Group(ch));
            else
                groups.get(groups.size() - 1).length++;

            prv = ch;
        }

        return groups;
    }

    private static long countSingleCharGroup(int total) {
        long res = 0;

        for (int i = 1; i <= total; i++)
            res += i;

        return res;
    }

    private static Scanner scanner;

    static {
        try {
            // expected: 1272919
            // actual:   1272467
            scanner = new Scanner(new FileInputStream("h:/input02.txt"));
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        long result = substrCount(n, s);

        System.out.println(String.valueOf(result));

        scanner.close();
//        String str = "aaaa";
//        System.out.println(substrCount(str.length(), str));
    }
}
