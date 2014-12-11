public class add2Num {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	// Add a pseudo node to simplify the operation
	ListNode res = new ListNode(0), pSum = res, p1 = l1, p2 = l2;
	int curr = 0;
	// Notice how do we remove the redundant code
	while ((p1 != null) || (p2 != null)) {
	    if (p1 != null) {
		curr += p1.val;
		p1 = p1.next;
	    }
	    if (p2 != null) {
		curr += p2.val;
		p2 = p2.next;
	    }
	    pSum.next = new ListNode(curr % 10);
	    pSum = pSum.next;
	    curr /= 10;
	}
	while (curr > 0) {
	    pSum.next = new ListNode(curr % 10);
	    pSum = pSum.next;
	    curr /= 10;
	}
	return res.next;
    }
    public static void main(String[] args) {
	add2Num solution = new add2Num();
	ListNode node1 = new ListNode(2);
	ListNode node2 = new ListNode(4);
	ListNode node3 = new ListNode(3);
	ListNode node4 = new ListNode(5);
	ListNode node5 = new ListNode(6);
	ListNode node6 = new ListNode(4);
	node1.next = node2;
	node2.next = node3;
	node4.next = node5;
	node5.next = node6;
	ListNode res = solution.addTwoNumbers(node1, node4), curr = res.next;
	System.out.print(res.val);
	while (curr != null) {
	    System.out.print("->" + curr.val);
	    curr = curr.next;
	}
	System.out.println();
    }
}