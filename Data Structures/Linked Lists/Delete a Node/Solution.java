/**
 * @author Oleg Cherednik
 * @since 28.10.2017
 */
public class Solution {
    Node Delete(Node head, int position) {
        if (head == null)
            return null;

        if (position == 0)
            return head.next;

        Node curr = head;

        for (int i = 0; i < position - 1 && curr.next != null; i++)
            curr = curr.next;

        curr.next = curr.next != null ? curr.next.next : null;

        return head;
    }

    class Node {
        int data;
        Node next;
    }
}
