import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 04.08.2018
 */
public class Solution {

    static int[][] swapNodes(int[][] indexes, int[] queries) {
        Node root = readTree(indexes);
        int[][] res = new int[queries.length][];

        for (int i = 0; i < queries.length; i++) {
            int K = queries[i];
            swap(root, K);
            res[i] = inOrder(root, new LinkedList<>()).stream().mapToInt(Integer::intValue).toArray();
        }

        return res;
    }

    static class Node {

        final int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    private static Node readTree(int[][] indexes) {
        Map<Integer, Node> nodes = new HashMap<>();

        for (int i = 1; i <= indexes.length; i++) {
            Node node = nodes.get(i);

            if (node == null)
                nodes.put(i, node = new Node(i));

            int next = indexes[i - 1][0];

            if (next != -1) {
                Node nextNode = nodes.get(next);

                if (nextNode == null)
                    nodes.put(next, nextNode = new Node(next));

                node.left = nextNode;
            }

            next = indexes[i - 1][1];

            if (next != -1) {
                Node nextNode = nodes.get(next);

                if (nextNode == null)
                    nodes.put(next, nextNode = new Node(next));

                node.right = nextNode;
            }
        }

        return nodes.get(1);
    }

    private static void swap(Node node, int K) {
        if (node == null)
            return;

        int i = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        do {
            int size = queue.size();
            boolean flag = ++i % K == 0;

            for (int j = 0; j < size; j++) {
                node = queue.poll();

                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
                if (flag && (node.left != null || node.right != null)) {
                    Node tmp = node.left;
                    node.left = node.right;
                    node.right = tmp;
                }
            }
        } while (!queue.isEmpty());
    }

    private static List<Integer> inOrder(Node root, List<Integer> data) {
        if (root != null) {
            inOrder(root.left, data);
            data.add(root.data);
            inOrder(root.right, data);
        }

        return data;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = Integer.parseInt(scanner.nextLine().trim());

        int[][] indexes = new int[n][2];

        for (int indexesRowItr = 0; indexesRowItr < n; indexesRowItr++) {
            String[] indexesRowItems = scanner.nextLine().split(" ");

            for (int indexesColumnItr = 0; indexesColumnItr < 2; indexesColumnItr++) {
                int indexesItem = Integer.parseInt(indexesRowItems[indexesColumnItr].trim());
                indexes[indexesRowItr][indexesColumnItr] = indexesItem;
            }
        }

        int queriesCount = Integer.parseInt(scanner.nextLine().trim());

        int[] queries = new int[queriesCount];

        for (int queriesItr = 0; queriesItr < queriesCount; queriesItr++) {
            int queriesItem = Integer.parseInt(scanner.nextLine().trim());
            queries[queriesItr] = queriesItem;
        }

        int[][] result = swapNodes(indexes, queries);

        for (int resultRowItr = 0; resultRowItr < result.length; resultRowItr++) {
            for (int resultColumnItr = 0; resultColumnItr < result[resultRowItr].length; resultColumnItr++) {
                System.out.print(String.valueOf(result[resultRowItr][resultColumnItr]));

                if (resultColumnItr != result[resultRowItr].length - 1) {
                    System.out.print(" ");
                }
            }

            if (resultRowItr != result.length - 1) {
                System.out.println();
            }
        }

        System.out.println();
    }

}
