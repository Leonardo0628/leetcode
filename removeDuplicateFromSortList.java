public class removeDuplicateFromSortList {
    public ListNode deleteDuplicates(ListNode head) {
	ListNode p1 = head;
	while (p1 != null) {
	    ListNode p2 = p1.next;
	    while ((p2 != null) && (p2.val == p1.val)) {
		p2 = p2.next;
	    }
	    p1.next = p2;
	    p1 = p2;
	}
	return head;
    }
    public static void main(String[] args) {
	removeDuplicateFromSortList solution = new removeDuplicateFromSortList();
	ListNode node1 = new ListNode(1);
	ListNode node2 = new ListNode(1);
	ListNode node3 = new ListNode(2);
	ListNode node4 = new ListNode(3);
	ListNode node5 = new ListNode(3);
	node1.next = node2;
	node2.next = node3;
	node3.next = node4;
	node4.next = node5;
	System.out.println(solution.deleteDuplicates(node1).next.val);
    }
}