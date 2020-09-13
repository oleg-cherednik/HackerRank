import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 04.12.2017
 */
public class Solution {

    static class Node {

        final int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Node root = readTree(scan);
        int T = scan.nextInt();

        for (int i = 0; i < T; i++) {
            int K = scan.nextInt();
            swap(root, K);
            inOrder(root);
            System.out.println();
        }
    }

    static Node readTree(Scanner scan) {
        int N = scan.nextInt();
        Map<Integer, Node> nodes = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            Node node = nodes.get(i);

            if (node == null)
                nodes.put(i, node = new Node(i));

            int next = scan.nextInt();

            if (next != -1) {
                Node nextNode = nodes.get(next);

                if (nextNode == null)
                    nodes.put(next, nextNode = new Node(next));

                node.left = nextNode;
            }

            next = scan.nextInt();

            if (next != -1) {
                Node nextNode = nodes.get(next);

                if (nextNode == null)
                    nodes.put(next, nextNode = new Node(next));

                node.right = nextNode;
            }
        }

        return nodes.get(1);
    }

    static void swap(Node node, int K) {
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

    static void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.printf("%d ", root.data);
            inOrder(root.right);
        }
    }

}
