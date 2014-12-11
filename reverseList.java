public class reverseList {
    public ListNode reverseBetween(ListNode head, int m, int n) {
	ListNode pseudo = new ListNode(0), p1 = pseudo;
	pseudo.next = head;
	head = pseudo;
	for (int i = 1; i < m; i++) {
	    p1 = p1.next;
	}
	ListNode left = p1, p2 = p1.next.next;
	p1 = p1.next;
	for (int i = 0; i < n - m; i++) {
	    ListNode tmp = p2.next;
	    p2.next = p1;
	    p1 = p2;
	    p2 = tmp;
	}
	ListNode right = left.next;
	left.next = p1;
	right.next = p2;
        return pseudo.next;
    }
    public static void main(String[] args) {
	reverseList solution = new reverseList();
	ListNode node1 = new ListNode(1);
	ListNode node2 = new ListNode(2);
	ListNode node3 = new ListNode(3);
	ListNode node4 = new ListNode(4);
	ListNode node5 = new ListNode(5);
	node1.next = node2;
	node2.next = node3;
	node3.next = node4;
	node4.next = node5;
	ListNode head = solution.reverseBetween(node1, 2, 4), p = head;
	while (p != null) {
	    System.out.print(p.val + "->");
	    p = p.next;
	}
	System.out.println("null");
    }
}