/**
 * @author Oleg Cherednik
 * @since 28.10.2017
 */
public class Solution {
    int FindMergeNode(Node headA, Node headB) {
        while(headA != null) {
            Node node = headB;

            while(node != null) {
                if(headA == node)
                    return node.data;
                node = node.next;
            }

            headA = headA.next;
        }

        return -1;
    }

    class Node {
        int data;
        Node next;
    }
}
