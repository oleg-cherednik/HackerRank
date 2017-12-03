import java.util.LinkedList;
import java.util.Queue;

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

    void levelOrder(Node root) {
        if (root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.remove();
            System.out.printf("%d ", node.data);

            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
    }

}
