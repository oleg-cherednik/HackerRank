import java.util.Deque;
import java.util.LinkedList;

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

    void topView(Node root) {
        if (root == null)
            return;

        Deque<Node> deque = new LinkedList<>();
        Node node = root.left;

        while (node != null) {
            deque.addFirst(node);
            node = node.left;
        }

        deque.addLast(root);
        node = root.right;

        while (node != null) {
            deque.addLast(node);
            node = node.right;
        }

        while (!deque.isEmpty()) {
            System.out.printf("%d ", deque.removeFirst().data);
        }
    }

}
