import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author Oleg Cherednik
 * @since 27.11.2017
 */
public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        scan.nextLine();

        Graph graph = new Graph(2 * N);

        for (int i = 0; i < N; i++)
            graph.addEdge(scan.nextInt(), scan.nextInt());

        CC cc = new CC(graph);
        System.out.printf("%d %d", cc.getMinCount(), cc.getMaxCount());
    }

    private static class Graph {

        private final int size;
        private final Map<Integer, Set<Integer>> map = new TreeMap<>();

        public Graph(int size) {
            this.size = size;
        }

        public void addEdge(int v, int w) {
            map.putIfAbsent(v, new HashSet<>());
            map.putIfAbsent(w, new HashSet<>());

            map.get(v).add(w);
            map.get(w).add(v);
        }
    }

    private static class CC {

        private final int[] cc;
        private final Map<Integer, Integer> map = new HashMap<>();
        private int count;

        public CC(Graph graph) {
            cc = new int[graph.size + 1];

            for (int i = 0; i < cc.length; i++)
                cc[i] = -1;

            if (graph.map.isEmpty())
                return;

            for (int v : graph.map.keySet())
                if (cc[v] < 0)
                    dfs(graph, v, count++);
        }

        private void dfs(Graph graph, int v, int count) {
            if (cc[v] >= 0)
                return;

            cc[v] = count;
            map.put(count, map.getOrDefault(count, 0) + 1);

            for (int w : graph.map.get(v))
                dfs(graph, w, count);
        }

        public int getMinCount() {
            return map.values().stream().min(Integer::compare).orElse(0);
        }

        public int getMaxCount() {
            return map.values().stream().max(Integer::compare).orElse(0);
        }
    }

}
