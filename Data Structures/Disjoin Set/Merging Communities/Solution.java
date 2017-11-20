import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 20.11.2017
 */
public class Solution {

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            int N = scan.nextInt();
            int Q = scan.nextInt();
            scan.nextLine();

            UnionFind unionFind = new UnionFind(N + 1);

            for (int i = 0; i < Q; i++) {
                String cmd = scan.next();

                if ("Q".equals(cmd))
                    System.out.println(unionFind.size(scan.nextInt()));
                else if ("M".equals(cmd))
                    unionFind.union(scan.nextInt(), scan.nextInt());
            }
        }
    }

    private static class UnionFind {
        private final int[] id;
        private final int[] sz;

        public UnionFind(int N) {
            id = new int[N];
            sz = new int[N];

            for (int i = 0; i < N; i++) {
                id[i] = i;
                sz[i] = 1;
            }
        }

        public int size(int p) {
            return sz[find(p)];
        }

        private int find(int p) {
            while (p != id[p])
                p = id[p];
            return p;
        }

        public void union(int p, int q) {
            int i = find(p);
            int j = find(q);

            if (i == j)
                return;

            if (sz[i] < sz[j]) {
                id[i] = j;
                sz[j] += sz[i];
            } else {
                id[j] = i;
                sz[i] += sz[j];
            }
        }
    }
}
