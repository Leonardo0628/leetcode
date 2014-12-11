import java.util.*;

public class copyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
	if (head == null) {
	    return null;
	}
	Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
	RandomListNode copyHead = new RandomListNode(head.label), p = head;
	map.put(head, copyHead);
	while (p != null) {
	    // Copy next node
	    if (p.next != null) {
		if (!map.containsKey(p.next)) {
		    map.put(p.next, new RandomListNode(p.next.label));
		}
		map.get(p).next = map.get(p.next);
	    }
	    // Copy random node
	    if (p.random != null) {
		if (!map.containsKey(p.random)) {
		    map.put(p.random, new RandomListNode(p.random.label));
		}
		map.get(p).random = map.get(p.random);
	    }
	    p = p.next;
	}
	return copyHead;
    }
    public static void main(String[] args) {
	copyListWithRandomPointer solution = new copyListWithRandomPointer();
	RandomListNode node1 = new RandomListNode(1);
	RandomListNode node2 = new RandomListNode(2);
	RandomListNode node3 = new RandomListNode(3);
	node1.next = node2;
	node2.next = node3;
	node1.random = node3;
	node3.random = node2;
	node2.random = node1;
	RandomListNode head = solution.copyRandomList(node1);
	System.out.println(head.label);
	System.out.println(head.next.label);
	System.out.println(head.random.label);
	System.out.println(head.next.random.label);
    }
}