import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 22.09.2017
 */
public class Solution {
    public static void main(String... args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();

        final class Node {
            final int row;
            final int col;
            final int val;
            int min = Integer.MAX_VALUE;
            boolean visited;

            Node(int row, int col, int val) {
                this.row = row;
                this.col = col;
                this.val = val;
            }

            public Node top(Node[]... a) {
                return row > 0 ? a[row - 1][col] : null;
            }

            public Node bottom(Node[]... a) {
                return row < n - 1 ? a[row + 1][col] : null;
            }

            public Node left(Node[]... a) {
                return col > 0 ? a[row][col - 1] : null;
            }

            public Node right(Node[]... a) {
                return col < m - 1 ? a[row][col + 1] : null;
            }

            @Override
            public String toString() {
                return String.format("[%d:%d], v:%d, min:%d%s", row, col, val, min, visited ? " - visited" : "");
            }
        }

        Node[][] a = new Node[n][m];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                a[i][j] = new Node(i, j, scan.nextInt());

        int q = scan.nextInt();

        for (int k = 0; k < q; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    a[i][j].min = Integer.MAX_VALUE;
                    a[i][j].visited = false;
                }
            }

            int r1 = scan.nextInt();
            int c1 = scan.nextInt();
            int r2 = scan.nextInt();
            int c2 = scan.nextInt();

            Node src = a[r1][c1];
            Node dist = a[r2][c2];

            src.min = src.val;

            Queue<Node> queue = new PriorityQueue<>((n1, n2) -> {
                int res = Integer.compare(n1.min, n2.min);
                return res != 0 ? Integer.compare(n1.val, n2.val) : res;
            });

            queue.add(src);

            // Dijkstra
            while (!queue.isEmpty()) {
                Node node = queue.remove();

                if (node.visited)
                    continue;

                node.visited = true;

                for (Node tmp : new Node[] { node.top(a), node.right(a), node.bottom(a), node.left(a) }) {
                    if (tmp != null && !tmp.visited) {
                        tmp.min = Math.min(tmp.min, node.min + tmp.val);
                        queue.add(tmp);
                    }
                }
            }

            System.out.println(dist.min);
        }

        scan.close();
    }
}
