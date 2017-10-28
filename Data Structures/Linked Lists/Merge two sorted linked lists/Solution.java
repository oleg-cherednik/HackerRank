/**
 * @author Oleg Cherednik
 * @since 28.10.2017
 */
public class Solution {
    Node mergeLists(Node headA, Node headB) {
        Node head = null;
        Node curr = null;

        while (headA != null && headB != null) {
            if (headA.data <= headB.data) {
                if (curr == null) {
                    curr = headA;
                    head = curr;
                } else {
                    curr.next = headA;
                    curr = curr.next;
                }

                headA = headA.next;
            } else {
                if (curr == null) {
                    curr = headB;
                    head = curr;
                } else {
                    curr.next = headB;
                    curr = curr.next;
                }

                headB = headB.next;
            }
        }

        if (headA != null) {
            if (curr == null) {
                curr = headA;
                head = curr;
            } else
                curr.next = headA;
        } else if (curr == null) {
            curr = headB;
            head = curr;
        } else
            curr.next = headB;

        return head;
    }

    class Node {
        int data;
        Node next;
    }
}
