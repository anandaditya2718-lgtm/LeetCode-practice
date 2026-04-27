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

    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;

        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) break;
        }

        
        if (fast == null || fast.next == null)
            return null;

        
        while (head != slow) {
            head = head.next;
            slow = slow.next;
        }

        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        System.out.println("Enter elements:");
        ListNode head = null, tail = null;
        List<ListNode> nodes = new ArrayList<>();

        
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            ListNode node = new ListNode(val);
            nodes.add(node);

            if (head == null) {
                head = tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }

        
        System.out.print("Enter position to create cycle (-1 for no cycle): ");
        int pos = sc.nextInt();

        if (pos != -1 && pos < n) {
            tail.next = nodes.get(pos);
        }

        
        ListNode cycleStart = detectCycle(head);

        if (cycleStart != null) {
            System.out.println("Cycle starts at node with value: " + cycleStart.val);
        } else {
            System.out.println("No cycle detected");
        }

        sc.close();
    }
}