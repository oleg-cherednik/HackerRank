/**
 * @author Oleg Cherednik
 * @since 11.12.2017
 */
public class Solution {
    static class Node {
        int val;   //Value
        int ht;      //Height
        Node left;   //Left child
        Node right;   //Right child
    }

    private static Node createNode(int val) {
        Node node = new Node();
        node.val = val;
        return node;
    }

    private static int height(Node node) {
        return node != null ? node.ht : -1;
    }

    private static int balanceFactor(Node node) {
        return node != null ? height(node.right) - height(node.left) : 0;
    }

    private static void fixHeight(Node node) {
        if (node != null)
            node.ht = Math.max(height(node.left), height(node.right)) + 1;
    }

    private static Node rotateRight(Node node) {
        Node root = node.left;
        node.left = root.right;
        root.right = node;

        fixHeight(node);
        fixHeight(root);

        return root;
    }

    private static Node rotateLeft(Node node) {
        Node root = node.right;
        node.right = root.left;
        root.left = node;

        fixHeight(node);
        fixHeight(root);

        return root;
    }

    private static Node balance(Node node) {
        fixHeight(node);

        if (balanceFactor(node) == 2) {
            if (balanceFactor(node.right) < 0)
                node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        if (balanceFactor(node) == -2) {
            if (balanceFactor(node.left) > 0)
                node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        return node;
    }

    static Node insert(Node root, int val) {
        if (root == null)
            return createNode(val);
        if (val < root.val)
            root.left = insert(root.left, val);
        else
            root.right = insert(root.right, val);

        return balance(root);
    }
}
