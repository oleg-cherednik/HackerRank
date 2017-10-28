/**
 * @author Oleg Cherednik
 * @since 28.10.2017
 */
public class Solution {
    Node RemoveDuplicates(Node head) {
        Node node = head;

        while (node.next != null) {
            if (node.data == node.next.data)
                node.next = node.next.next;
            else
                node = node.next;
        }

        return head;
    }

    class Node {
        int data;
        Node next;
    }
}
