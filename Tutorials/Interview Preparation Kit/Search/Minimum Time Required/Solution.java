import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author Oleg Cherednik
 * @since 08.01.2019
 */
public class Solution {

    static long minTime(long[] machines, long goal) {
        Map<Long, Long> map = new TreeMap<>();

        for (long machine : machines)
            map.compute(machine, (id, count) -> Optional.ofNullable(count).orElse(0L) + 1);

        long day = 0;
        long currGoal = 0;

        do {
            day++;

            for (Map.Entry<Long, Long> entry : map.entrySet()) {
                if (day % entry.getKey() != 0)
                    continue;

                currGoal += entry.getValue();
            }
        } while (currGoal < goal);

        return day;
    }

    private static Scanner scanner;// = new Scanner(System.in);

    static {
        try {
            // 2 -82
            scanner = new Scanner(new FileInputStream("h:/input02.txt"));
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String[] nGoal = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nGoal[0]);

        long goal = Long.parseLong(nGoal[1]);

        long[] machines = new long[n];

        String[] machinesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long machinesItem = Long.parseLong(machinesItems[i]);
            machines[i] = machinesItem;
        }

        long ans = minTime(machines, goal);

        System.out.println(ans);

        scanner.close();
    }

}
