public class swapNodeInPair {
    public ListNode swapPairs(ListNode head) {
	ListNode pseudo = new ListNode(0);
	pseudo.next = head;
	ListNode pre = pseudo, curr = head;
	while ((curr != null) && (curr.next != null)) {
	    ListNode node = curr.next;
	    curr.next = curr.next.next;
	    node.next = curr;
	    pre.next = node;
	    pre = pre.next.next;
	    curr = curr.next;
	}
	return pseudo.next;
    }
    public static void main(String[] args) {
	swapNodeInPair solution = new swapNodeInPair();
	ListNode node1 = new ListNode(1);
	ListNode node2 = new ListNode(2);
	ListNode node3 = new ListNode(3);
	ListNode node4 = new ListNode(4);
	//node1.next = node2;
	//node2.next = node3;
	//node3.next = node4;
	System.out.println(solution.swapPairs(null));
    }
}