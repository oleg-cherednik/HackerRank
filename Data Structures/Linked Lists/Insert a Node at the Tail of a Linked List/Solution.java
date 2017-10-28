/**
 * @author Oleg Cherednik
 * @since 28.10.2017
 */
public class Solution {
    Node Insert(Node head, int data) {
        if (head == null) {
            head = new Node();
            head.data = data;
        } else {
            Node node = head;

            while (node.next != null) {
                node = node.next;
            }

            node.next = new Node();
            node.next.data = data;
        }

        return head;
    }

    class Node {
        int data;
        Node next;
    }
}
