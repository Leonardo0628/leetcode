public class reverseNodeInKGroup {
    private ListNode reverse(ListNode head, int k) {
	ListNode p1 = head;
	int i;
	for (i = 0; i < k; i++) {
	    p1 = p1.next;
	    if (p1 == null) { break; }
	}
	// Length is less than k
	if (i < k) { return null; }
	p1 = head.next;
	ListNode p2 = p1.next;
	for (i = 0; i < k - 1; i++) {
	    ListNode tmp = p2.next;
	    p2.next = p1;
	    p1 = p2;
	    p2 = tmp;
	}
	ListNode tmp = head.next;
	head.next.next = p2;
	head.next = p1;
	return tmp;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode pseudo = new ListNode(0);
	pseudo.next = head;
	ListNode p = pseudo;
	while (p != null) {
	    p = reverse(p, k);
	}
	return pseudo.next;
    }
    public static void main(String[] args) {
	reverseNodeInKGroup solution = new reverseNodeInKGroup();
	ListNode node1 = new ListNode(1);
	ListNode node2 = new ListNode(2);
	ListNode node3 = new ListNode(3);
	ListNode node4 = new ListNode(4);
	ListNode node5 = new ListNode(5);
	node1.next = node2;
	node2.next = node3;
	node3.next = node4;
	node4.next = node5;
	ListNode head = solution.reverseKGroup(node1, 3), p = head;
	while (p != null) {
	    System.out.print(p.val + "->");
	    p = p.next;
	}
	System.out.println("null");
    }
}