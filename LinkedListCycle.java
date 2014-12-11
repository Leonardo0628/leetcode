public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
	    return false;
	}
	// One fast pointer, one slow pointer
	ListNode p1 = head, p2 = head.next;
	while (p1 != p2) {
	    if (p1 != null) {
		p1 = p1.next;
	    } else {
		return false;
	    }
	    if ((p2 != null) && (p2.next != null)) {
		p2 = p2.next.next;
	    } else {
		return false;
	    }
	}
	return true;
    }
    public static void main(String[] args) {
	LinkedListCycle solution = new LinkedListCycle();
	ListNode head = new ListNode(1);
	ListNode node1 = new ListNode(2);
	System.out.println(solution.hasCycle(null));
	System.out.println(solution.hasCycle(head));
	head.next = head;
	System.out.println(solution.hasCycle(head));
	head.next = node1;
	System.out.println(solution.hasCycle(head));
	node1.next = node1;
	System.out.println(solution.hasCycle(head));
    }
}