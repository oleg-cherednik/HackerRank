/**
 * @author Oleg Cherednik
 * @since 02.12.2017
 */
public class Solution {
    class Node {
        int data;
        Node left;
        Node right;
    }

    void inOrder(Node root) {
        if (root == null)
            return;

        inOrder(root.left);
        System.out.printf("%d ", root.data);
        inOrder(root.right);
    }

}
