/**
 * @author Oleg Cherednik
 * @since 18.05.2018
 */
public class Solution {

    /* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.

    The Node class is defined as follows:
        class Node {
            int data;
            Node left;
            Node right;
         }
    */
    static boolean checkBST(Node root) {
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean checkBST(Node node, int min, int max) {
        if (node == null)
            return true;
        if (node.data <= min || node.data >= max)
            return false;
        return checkBST(node.left, min, node.data) && checkBST(node.right, node.data, max);
    }

    private static final class Node {

        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }
}
