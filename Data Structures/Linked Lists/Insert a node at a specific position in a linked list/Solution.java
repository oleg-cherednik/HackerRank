/**
 * @author Oleg Cherednik
 * @since 28.10.2017
 */
public class Solution {
    Node InsertNth(Node head, int data, int position) {
        Node node = new Node();
        node.data = data;

        if (head == null)
            return node;

        if (position == 0) {
            node.next = head;
            return node;
        }

        Node curr = head;

        for (int i = 0; i < position - 1 && curr.next != null; i++)
            curr = curr.next;

        node.next = curr.next;
        curr.next = node;

        return head;
    }

    class Node {
        int data;
        Node next;
    }
}
