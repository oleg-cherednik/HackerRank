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

    void postOrder(Node root) {
        if (root == null)
            return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.printf("%d ", root.data);
    }

}
