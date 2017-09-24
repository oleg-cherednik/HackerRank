package cop.hackerrank.algorithms.graphtheory;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * <h1>Find the Path</h1>
 * You are given a table, <tt>a</tt>, with <tt>n</tt> rows and <tt>m</tt> columns. The top-left corner of the table has coordinates <tt>(0,0)</tt>,
 * and the bottom-right corner has coordinates <tt>(n-1, m-1)</tt>. The <tt>i<sup>th</sup></tt> cell contains integer <tt>a<sub>i,j</sub></tt>.
 * <p>
 * A path in the table is a sequence of cells <tt>(r<sub>1</sub>, c<sub>1</sub>),(r<sub>2</sub>, c<sub>2</sub>),...,(r<sub>k</sub>,
 * c<sub>k</sub>)</tt> such that for each <tt>i Є {1,..., k01}</tt>, cell <tt>(r<sub>i</sub>, c<sub>i</sub>)</tt> and cell <tt>(r<sub>i+1</sub>,
 * c<sub>i+1</sub>)</tt> share a side.
 * <p>
 * The weight of the path <tt>(r<sub>1</sub>, c<sub>1</sub>),(r<sub>2</sub>, c<sub>2</sub>),...,(r<sub>k</sub>, c<sub>k</sub>)</tt> is defined by
 * <tt>∑<sup>k</sup><sub>i=1</sub>a<sub>ri,ci</sub></tt> where <tt>a<sub>ri,ci</sub></tt> is the weight of the cell
 * <tt>(r<sub>i</sub>,c<sub>i</sub>)</tt>.
 * <p>
 * You must answer <tt>q</tt> queries. In each query, you are given the coordinates of two cells, <tt>(r<sub>1</sub>,c<sub>1</sub>)</tt> and
 * <tt>(r<sub>2</sub>,c<sub>2</sub>)</tt>. You must find and print the minimum possible weight of a path connecting them.
 * <p>
 * <b>Note:</b> A cell can share sides with at most 4 other cells. A cell with coordinates <tt>(r,c)</tt> shares sides with <tt>(r-1,c)</tt>,
 * <tt>(r+1,c)</tt>, <tt>(r,c-1)</tt> and <tt>(r,c+1)</tt>.
 * <h3>Input Format</h3>
 * The first line contains 2 space-separated integers, <tt>n</tt> (the number of rows in <tt>a</tt>) and <tt>m</tt> (the number of columns in
 * <tt>a</tt>), respectively.<br>
 * Each of <tt>n</tt> subsequent lines contains <tt>m</tt> space-separated integers. The <tt>j<sup>th</sup></tt> integer in the
 * <tt>i<sup>th</sup></tt> line denotes the value of <tt>a<sub>i,j</sub></tt>.<br>
 * The next line contains a single integer, <tt>q</tt>, denoting the number of queries.<br>
 * Each of the <tt>q</tt> subsequent lines describes a query in the form of 4 space-separated integers: <tt>r<sub>1</sub></tt>,
 * <tt>c<sub>1</sub></tt>, <tt>r<sub>2</sub></tt>, and <tt>c<sub>2</sub></tt>, respectively.
 * <h3>Constraints</h3>
 * <ul>
 * <li>1 <= n <= 7</li>
 * <li>1 <= m <= 5×10<sup>3</sup></li>
 * <li>0 <= a<sub>i,j</sub> < 3×10<sup>3</sup></li>
 * <li>1 <= q < 3×10<sup>3</sup></li>
 * </ul>
 * For each query:
 * <ul>
 * <li>0 <= r<sub>1</sub>,r<sub>2</sub> < n</li>
 * <li>0 <= c<sub>1</sub>,c<sub>2</sub> < m</li>
 * </ul>
 * <h3>Output Format</h3>
 * On a new line for each query, print a single integer denoting the minimum possible weight of a path between <tt>(r<sub>1</sub>,c<sub>1</sub>)</tt>
 * and (r<sub>2</sub>,c<sub>2</sub>).
 * <h3>Sample Input</h3>
 * <pre>
 * 3 5
 * 0 0 0 0 0
 * 1 9 9 9 1
 * 0 0 0 0 0
 * 3
 * 0 0 2 4
 * 0 3 2 3
 * 1 1 1 3
 * </pre>
 * <h3>Sample Output</h3>
 * <pre>
 * 1
 * 1
 * 18
 * </pre>
 * <h3>Explanation</h3>
 * The input table looks like this:
 * <pre>
 * <img src="image1.png"/>
 * </pre>
 * The first two queries are explained below:
 * <ol>
 * <li>
 * In the first query, we have to find the minimum possible weight of a path connecting and (0,0) and (2,4). Here is one possible path:
 * <pre>
 * <img src="image2.png"/>
 * </pre>
 * The total weight of the path is <tt>0+1+0+0+0+0+0=1</tt>.
 * </li>
 * <li>
 * In the second query, we have to find the minimum possible weight of a path connecting (0,3) and (2,3). Here is one possible path:
 * <pre>
 * <img src="image3.png"/>
 * </pre>
 *
 * </li>
 * </ol>
 * The total weight of the path is <tt>0+0+1+0+0-1</tt>.
 *
 * @author Oleg Cherednik
 * @since 22.09.2017
 */
public class FindThePath {
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
