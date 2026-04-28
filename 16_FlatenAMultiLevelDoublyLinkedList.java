import java.util.*;

class Node {
    int val;
    Node prev;
    Node next;
    Node child;

    Node(int val) {
        this.val = val;
        this.prev = null;
        this.next = null;
        this.child = null;
    }
}

public class Main {

    
    public static Node flatten(Node head) {
        flattenTail(head);
        return head;
    }

    private static Node flattenTail(Node head) {
        Node curr = head;
        Node last = null;

        while (curr != null) {
            Node next = curr.next;

            if (curr.child != null) {
                Node childHead = curr.child;
                Node childTail = flattenTail(childHead);

                
                curr.next = childHead;
                childHead.prev = curr;
                curr.child = null;

                
                if (next != null) {
                    childTail.next = next;
                    next.prev = childTail;
                }

                last = childTail;
                curr = childTail;
            } else {
                last = curr;
            }

            curr = curr.next;
        }

        return last;
    }

    
    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter number of nodes in main list: ");
        int n = sc.nextInt();

        Node head = null, tail = null;
        List<Node> nodes = new ArrayList<>();

        System.out.println("Enter main list values:");
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            Node node = new Node(val);
            nodes.add(node);

            if (head == null) {
                head = tail = node;
            } else {
                tail.next = node;
                node.prev = tail;
                tail = node;
            }
        }

        
        System.out.print("Enter number of child connections: ");
        int c = sc.nextInt();

        for (int i = 0; i < c; i++) {
            System.out.print("Enter index where child attaches (0-based): ");
            int idx = sc.nextInt();

            System.out.print("Enter child list size: ");
            int size = sc.nextInt();

            Node childHead = null, childTail = null;

            System.out.println("Enter child list values:");
            for (int j = 0; j < size; j++) {
                int val = sc.nextInt();
                Node node = new Node(val);

                if (childHead == null) {
                    childHead = childTail = node;
                } else {
                    childTail.next = node;
                    node.prev = childTail;
                    childTail = node;
                }
            }

            nodes.get(idx).child = childHead;
        }

        
        head = flatten(head);

        
        System.out.println("Flattened list:");
        printList(head);

        sc.close();
    }
}