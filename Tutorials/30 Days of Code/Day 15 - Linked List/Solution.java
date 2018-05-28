import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 28.05.2018
 */
public class Solution {

    public static Node insert(Node head, int data) {
        if(head == null)
            return new Node(data);

        Node node = head;

        while(node.next != null)
            node = node.next;

        node.next = new Node(data);

        return head;
    }

    public static void display(Node head) {
        Node start = head;
        while (start != null) {
            System.out.println(start.data + " ");
            start = start.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = null;
        int N = sc.nextInt();

        while (N-- > 0) {
            int ele = sc.nextInt();
            head = insert(head, ele);
        }
        display(head);
        sc.close();
    }
}

class Node {

    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
