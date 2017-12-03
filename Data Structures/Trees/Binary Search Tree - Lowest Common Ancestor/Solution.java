/**
 * @author Oleg Cherednik
 * @since 04.12.2017
 */
public class Solution {
    class Node {
        int data;
        Node left;
        Node right;
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

}
