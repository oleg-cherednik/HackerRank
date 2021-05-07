import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 07.05.2021
 */
public class Solution {

    static long minTime(long[] machines, long goal) {
        long maxDays = 0;

        for (long machine : machines)
            maxDays = Math.max(maxDays, goal * machine);

        return minTime(machines, goal, 0, maxDays, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static long minTime(long[] machines, long goal, long minDays, long maxDays, long minGoal, long maxGoal) {
        if (minGoal == maxGoal)
            return minDays;
        if (minDays + 1 == maxDays)
            return minGoal == goal ? minDays : maxDays;

        long days = (minDays + maxDays) / 2;
        long total = 0;

        for (int i = 0; i < machines.length; i++)
            total += days / machines[i];

        if (total >= goal)
            return minTime(machines, goal, minDays, days, minGoal, total);
        return minTime(machines, goal, days, maxDays, total, maxGoal);
    }

    private static Scanner scanner;// = new Scanner(System.in);

    static {
        try {
            // 2 - 82
            // 5 - 304844592
            scanner = new Scanner(new FileInputStream("e:/input05.txt"));
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
