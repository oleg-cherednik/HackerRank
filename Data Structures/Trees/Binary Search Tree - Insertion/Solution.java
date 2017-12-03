/**
 * @author Oleg Cherednik
 * @since 03.12.2017
 */
public class Solution {
    static class Node {
        int data;
        Node left;
        Node right;
    }

    static Node Insert(Node root, int value) {
        if (root == null) {
            Node node = new Node();
            node.data = value;
            return node;
        }

        if (value < root.data) {
            if (root.left == null) {
                Node node = new Node();
                node.data = value;
                root.left = node;
            } else
                Insert(root.left, value);
        } else {
            if (root.right == null) {
                Node node = new Node();
                node.data = value;
                root.right = node;
            } else
                Insert(root.right, value);
        }

        return root;
    }

}
