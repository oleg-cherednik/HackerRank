import java.util.ArrayList;
import java.util.List;

/**
 * @author Oleg Cherednik
 * @since 28.10.2017
 */
public class Solution {
    int GetNode(Node head, int n) {
        List<Node> nodes = new ArrayList<>();

        while (head != null) {
            nodes.add(head);
            head = head.next;
        }

        return nodes.get(nodes.size() - n - 1).data;
    }

    class Node {
        int data;
        Node next;
    }
}
