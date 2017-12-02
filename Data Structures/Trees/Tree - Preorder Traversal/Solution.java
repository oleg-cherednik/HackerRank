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

    void preOrder(Node root) {
        if (root == null)
            return;

        System.out.printf("%d ", root.data);
        preOrder(root.left);
        preOrder(root.right);
    }

}
