import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author Oleg Cherednik
 * @since 28.10.2017
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int Q = scan.nextInt();

        Map<Integer, List<Integer>> seqList = new TreeMap<Integer, List<Integer>>();
        int lastAnswer = 0;

        for (int i = 0; i < Q; i++) {
            int k = scan.nextInt();
            int x = scan.nextInt();
            int y = scan.nextInt();
            int seq = (x ^ lastAnswer) % N;

            if (!seqList.containsKey(seq))
                seqList.put(seq, new ArrayList<Integer>());

            if (k == 1)
                seqList.get(seq).add(y);
            else if (k == 2)
                System.out.println(lastAnswer = seqList.get(seq).get(y % seqList.get(seq).size()));
        }

        scan.close();
    }
}
