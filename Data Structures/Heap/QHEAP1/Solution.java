import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Oleg Cherednik
 * @since 04.11.2017
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int Q = scan.nextInt();
        scan.nextLine();

        Set<Long> heap = new TreeSet<>();

        for (int i = 0; i < Q; i++) {
            int t = scan.nextInt();

            if (t == 1)
                heap.add(scan.nextLong());
            else if (t == 2)
                heap.remove(scan.nextLong());
            else if (t == 3)
                System.out.println(heap.iterator().next());
        }

        scan.close();
    }

}

