/**
 * @author Oleg Cherednik
 * @since 28.10.2017
 */
public class Solution {
    Node SortedInsert(Node head, int data) {
        Node node = new Node();
        node.data = data;

        if (head == null)
            return node;

        if (head.data >= data) {
            node.next = head;
            head.prev = node;
            return node;
        }

        Node curr = head;

        while (curr.data <= data && curr.next != null)
            curr = curr.next;

        if (curr.data >= data) {
            node.next = curr;
            node.prev = curr.prev;
            curr.prev.next = node;
            curr.prev = node;
        } else {
            curr.next = node;
            node.prev = curr;
        }

        return head;
    }

    class Node {
        int data;
        Node next;
        Node prev;
    }
}
