/**
 * @author Oleg Cherednik
 * @since 28.10.2017
 */
public class Solution {
    Node Insert(Node head, int x) {
        Node node = new Node();
        node.data = x;
        node.next = head;
        return node;
    }

    class Node {
        int data;
        Node next;
    }
}
