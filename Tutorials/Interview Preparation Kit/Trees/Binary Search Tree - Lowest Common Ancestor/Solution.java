import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 04.08.2018
 */
public class Solution {

    static class Node {

        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    static Node lca(Node root, int v1, int v2) {
        if (root == null)
            return null;
        if (root.data == v1 || root.data == v2)
            return root;

        int min = Math.min(v1, v2);
        int max = Math.max(v1, v2);

        if (max < root.data)
            return root.left != null ? lca(root.left, v1, v2) : root;
        if (min > root.data)
            return root.right != null ? lca(root.right, v1, v2) : root;
        return root;
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
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
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while (t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        int v1 = scan.nextInt();
        int v2 = scan.nextInt();
        scan.close();
        Node ans = lca(root, v1, v2);
        System.out.println(ans.data);
    }

}
