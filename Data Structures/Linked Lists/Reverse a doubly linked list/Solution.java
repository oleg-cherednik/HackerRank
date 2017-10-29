/**
 * @author Oleg Cherednik
 * @since 28.10.2017
 */
public class Solution {
    Node Reverse(Node head) {
        if (head == null)
            return null;

        while (head.next != null) {
            Node node = head.next;
            head.next = head.prev;
            head.prev = node;
            head = node;
        }

        head.next = head.prev;

        return head;
    }

    class Node {
        int data;
        Node next;
        Node prev;
    }
}
