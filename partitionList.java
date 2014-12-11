public class partitionList {
    public ListNode partition(ListNode head, int x) {
	ListNode less = new ListNode(0), greater = new ListNode(0);
	ListNode p1 = less, p2 = greater, p3 = head;
	while (p3 != null) {
	    if (p3.val < x) {
		p1.next = p3;
		p1 = p1.next;
	    } else {
		p2.next = p3;
		p2 =p2.next;
	    }
	    p3 = p3.next;
	}
	p2.next = null;
	p1.next = greater.next;
	return less.next;
    }
    public static void main(String[] args) {
	partitionList solution = new partitionList();
	ListNode node1 = new ListNode(1);
	ListNode node2 = new ListNode(4);
	ListNode node3 = new ListNode(3);
	ListNode node4 = new ListNode(2);
	ListNode node5 = new ListNode(5);
	ListNode node6 = new ListNode(2);
	node1.next = node2;
	node2.next = node3;
	node3.next = node4;
	node4.next = node5;
	node5.next = node6;
	ListNode head = solution.partition(node1, 3), p = head;
	while (p != null) {
	    System.out.print(p.val + "->");
	    p = p.next;
	}
	System.out.println("null");
    }
}