class Solution {
    public Node flatten(Node head) {
        flattentail(head);
        return head;
    }

    private Node flattentail(Node head) {
        Node curr = head;
        Node last = null;

        while (curr != null) {
            Node next = curr.next;

            // If child exists
            if (curr.child != null) {
                Node childHead = curr.child;
                Node childTail = flattentail(childHead);

                // Connect curr -> child
                curr.next = childHead;
                childHead.prev = curr;
                curr.child = null;

                // Connect childTail -> next
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
}