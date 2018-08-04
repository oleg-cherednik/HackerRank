import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import static java.util.stream.Collectors.joining;

/**
 * @author Oleg Cherednik
 * @since 04.08.2018
 */
public class Solution {

    static List<Integer> freqQuery(List<int[]> queries) {
        List<Integer> res = new LinkedList<>();
        Map<Integer, Integer> mapCount = new HashMap<>();
        Map<Integer, Set<Integer>> mapFreq = new HashMap<>();

        for (int[] query : queries) {
            int cmd = query[0];
            int data = query[1];
            int count = mapCount.getOrDefault(data, 0);

            if (cmd == 1) {
                if (mapFreq.containsKey(count))
                    mapFreq.get(count).remove(data);

                count++;

                mapCount.put(data, count);
                mapFreq.compute(count, (value, values) -> {
                    values = values != null ? values : new HashSet<>();
                    values.add(data);
                    return values;
                });
            } else if (cmd == 2) {
                if (count > 0) {
                    if (mapFreq.containsKey(count))
                        mapFreq.get(count).remove(data);

                    count = Math.max(0, count - 1);

                    mapCount.put(data, count);
                    mapFreq.compute(count, (value, values) -> {
                        values = values != null ? values : new HashSet<>();
                        values.add(data);
                        return values;
                    });
                }
            } else if (cmd == 3)
                res.add(mapFreq.getOrDefault(data, Collections.emptySet()).isEmpty() ? 0 : 1);
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        List<int[]> queries = new ArrayList<>();

        for (int i = 0; i < q; i++)
            queries.add(new int[] { scanner.nextInt(), scanner.nextInt() });

        List<Integer> ans = freqQuery(queries);

        System.out.println(ans.stream().map(Object::toString).collect(joining("\n")));
    }

}
