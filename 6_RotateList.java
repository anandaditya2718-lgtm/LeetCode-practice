import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Main {

    
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0)
            return head;

        
        ListNode curr = head;
        int len = 1;
        while (curr.next != null) {
            curr = curr.next;
            len++;
        }

        
        curr.next = head;

        
        k = k % len;

        
        int stepsToNewHead = len - k;
        ListNode newTail = curr;

        while (stepsToNewHead-- > 0) {
            newTail = newTail.next;
        }

        
        ListNode newHead = newTail.next;

        
        newTail.next = null;

        return newHead;
    }

    
    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
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

        
        System.out.print("Enter k: ");
        int k = sc.nextInt();

        
        head = rotateRight(head, k);

        
        System.out.println("Rotated List:");
        printList(head);

        sc.close();
    }
}