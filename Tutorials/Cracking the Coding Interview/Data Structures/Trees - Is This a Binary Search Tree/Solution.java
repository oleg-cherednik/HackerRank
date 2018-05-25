/**
 * @author Oleg Cherednik
 * @since 18.05.2018
 */
public class Solution {

    class Node {
        int data;
        Node left;
        Node right;
    }

    boolean checkBST(Node root) {
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean checkBST(Node node, int min, int max) {
        if (node == null)
            return true;
        if (node.data <= min || node.data >= max)
            return false;
        return checkBST(node.left, min, node.data) && checkBST(node.right, node.data, max);
    }
}
