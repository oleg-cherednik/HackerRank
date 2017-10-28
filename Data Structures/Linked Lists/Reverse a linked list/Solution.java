/**
 * @author Oleg Cherednik
 * @since 28.10.2017
 */
public class Solution {
    Node Reverse(Node head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;

        Node node = head;
        head = Reverse(head.next);

        Node curr = head;

        while (curr.next != null)
            curr = curr.next;

        curr.next = node;
        node.next = null;

        return head;
    }

    class Node {
        int data;
        Node next;
    }
}
