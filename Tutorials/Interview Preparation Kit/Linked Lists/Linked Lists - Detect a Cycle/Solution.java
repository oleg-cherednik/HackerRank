/**
 * @author Oleg Cherednik
 * @since 04.08.2018
 */
public class Solution {
    /*
        Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.

        A Node is defined as:
            class Node {
                int data;
                Node next;
            }
     */

    boolean hasCycle(Node head) {
        if (head == null)
            return false;

        Node it1 = head;
        Node it2 = head;

        while (true) {
            it1 = it1.next;
            it2 = it2.next;
            it2 = it2 != null ? it2.next : null;

            if (it2 == null)
                return false;
            if (it1 == it2)
                return true;
        }
    }

    private static final class Node {

        int data;
        Node next;
    }
}
