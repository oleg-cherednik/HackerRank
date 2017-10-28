/**
 * @author Oleg Cherednik
 * @since 28.10.2017
 */
public class Solution {
    int FindMergeNode(Node headA, Node headB) {
        Node it1 = headA;
        Node it2 = headB;

        while (it1 != it2) {
            it1 = it1.next != null ? it1.next : headB;
            it2 = it2.next != null ? it2.next : headA;
        }

        return it1.data;
    }

    class Node {
        int data;
        Node next;
    }
}
