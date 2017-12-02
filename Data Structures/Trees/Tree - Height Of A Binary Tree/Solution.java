import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 02.12.2017
 */
public class Solution {
    public static void main(String... args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;

        while (t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }

        scan.close();

        int height = height(root);
        System.out.println(height);
    }

    static int height(Node root) {
        return root != null ? Math.max(height(root.left), height(root.right)) + 1 : -1;
    }

    public static Node insert(Node root, int data) {
        if (root == null)
            return new Node(data);

        Node cur;

        if (data <= root.data) {
            cur = insert(root.left, data);
            root.left = cur;
        } else {
            cur = insert(root.right, data);
            root.right = cur;
        }

        return root;
    }

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

}
