import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Main {

    public static ListNode partition(ListNode head, int x) {
        ListNode slist = new ListNode();
        ListNode blist = new ListNode();

        ListNode small = slist;
        ListNode big = blist;

        while (head != null) {
            ListNode nextNode = head.next; // safe detach
            head.next = null;

            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                big.next = head;
                big = big.next;
            }

            head = nextNode;
        }

        small.next = blist.next;

        return slist.next;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        System.out.println("Enter elements:");
        ListNode head = null, tail = null;

        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            ListNode node = new ListNode(val);

            if (head == null) {
                head = tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }

        System.out.print("Enter value x: ");
        int x = sc.nextInt();

        head = partition(head, x);

        System.out.println("Partitioned List:");
        printList(head);

        sc.close();
    }
}