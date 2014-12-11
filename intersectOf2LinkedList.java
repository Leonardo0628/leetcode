public class intersectOf2LinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
	ListNode pA = headA, pB = headB;
	while (pA != null) {
	    lenA++;
	    pA = pA.next;
	}
	while (pB != null) {
	    lenB++;
	    pB = pB.next;
	}
	pA = headA;
	pB = headB;
	if (lenA > lenB) {
	    pA = headB;
	    pB = headA;
	}
	for (int i = 0; i < Math.abs(lenA - lenB); i++) {
	    pB = pB.next;
	}
	while ((pA != null) && (pB != null) && (pA != pB)) {
	    pA = pA.next;
	    pB = pB.next;
	}
	return pA;
    }
    public static void main(String[] args) {
	intersectOf2LinkedList solution = new intersectOf2LinkedList();
	ListNode node1 = new ListNode(1);
	ListNode node2 = new ListNode(2);
	ListNode node3 = new ListNode(3);
	node1.next = node3;
	System.out.println(solution.getIntersectionNode(node1, node2));
	node2.next = node3;
	System.out.println(solution.getIntersectionNode(node1, node2));
    }
}