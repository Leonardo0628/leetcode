public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if ((head == null) || (head.next == null)) {
	    return null;
	}
	ListNode p1 = head.next, p2 = head.next.next;
	while (p1 != p2) {
	    if (p1 != null) {
		p1 = p1.next;
	    } else {
		return null;
	    }
	    if ((p2 != null) && (p2.next != null)) {
		p2 = p2.next.next;
	    } else {
		return null;
	    }
	}
	p2 = head;
	while (p1 != p2) {
	    p1 = p1.next;
	    p2 = p2.next;
	}
	return p1;
    }
    public static void main(String[] args) {
	LinkedListCycleII solution = new LinkedListCycleII();
	ListNode head = new ListNode(1);
	ListNode node1 = new ListNode(2);
	System.out.println(solution.detectCycle(null));
	System.out.println(solution.detectCycle(head));
	head.next = head;
	System.out.println(solution.detectCycle(head));
	head.next = node1;
	System.out.println(solution.detectCycle(head));
	node1.next = node1;
	System.out.println(solution.detectCycle(head));
    }
}