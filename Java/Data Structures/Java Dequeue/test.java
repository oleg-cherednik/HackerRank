import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Oleg Cherednik
 * @since 18.09.2017
 */
public class test {
    public static void main(String... args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();

        Set<Integer> set = new HashSet<>();
        int res = 0;

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.add(num);
            set.add(num);

            if (deque.size() < m)
                continue;
            if (deque.size() > m) {
                int tmp = deque.remove();

                if (!deque.contains(tmp))
                    set.remove(tmp);
            }

            if (set.size() > res)
                res = set.size();
            if (res == m)
                break;
        }

        System.out.println(res);
    }
}
