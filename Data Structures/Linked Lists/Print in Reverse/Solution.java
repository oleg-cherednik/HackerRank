/**
 * @author Oleg Cherednik
 * @since 28.10.2017
 */
public class Solution {
    void ReversePrint(Node head) {
        if (head == null)
            return;
        ReversePrint(head.next);
        System.out.println(head.data);
    }

    class Node {
        int data;
        Node next;
    }
}
