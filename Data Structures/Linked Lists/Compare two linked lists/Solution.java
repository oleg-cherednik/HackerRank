/**
 * @author Oleg Cherednik
 * @since 28.10.2017
 */
public class Solution {
    int CompareLists(Node headA, Node headB) {
        while (headA != null && headB != null) {
            if (headA.data != headB.data)
                return 0;
            headA = headA.next;
            headB = headB.next;
        }

        return headA == null && headB == null ? 1 : 0;
    }

    class Node {
        int data;
        Node next;
    }
}
