/**
 * @author Oleg Cherednik
 * @since 28.10.2017
 */
public class Solution {
    void Print(Node head) {
        if (head != null) {
            System.out.println(head.data);
            Print(head.next);
        }
    }

    class Node {
        int data;
        Node next;
    }
}
