/**
 * @author Oleg Cherednik
 * @since 28.10.2017
 */
public class Solution {
    boolean hasCycle(Node head) {
        if (head == null || head.next == null)
            return false;

        Node it1 = head;
        Node it2 = head.next;

        while (true) {
            if (it1 == it2)
                return true;
            if (it2 == null)
                return false;

            it1 = it1.next;
            it2 = it2.next;
            it2 = it2 != null ? it2.next : null;
        }
    }

    class Node {
        int data;
        Node next;
    }
}
