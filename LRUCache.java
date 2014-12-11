import java.util.*;

class doubleListNode {
    int key, value;
    doubleListNode prev, next;
    doubleListNode(int key, int value) {
	this.key = key;
	this.value = value;
    }
}

public class LRUCache {
    
    private doubleListNode head, tail;
    private int length, capacity;
    private Map<Integer, doubleListNode> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
	length = 0;
	head = new doubleListNode(0, 0);
	tail = new doubleListNode(0, 0);
	head.next = tail;
	tail.prev = head;
	map = new HashMap<Integer, doubleListNode>();
    }
    
    private void moveTail(doubleListNode node) {
	node.prev.next = node.next;
	node.next.prev = node.prev;
	node.next = tail;
	node.prev = tail.prev;
	tail.prev.next = node;
	tail.prev = node;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
	    doubleListNode node = map.get(key);
	    moveTail(node);
	    return node.value;
	} else {
	    return -1;
	}
    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
	    map.get(key).value = value;
	    moveTail(map.get(key));
	    return;
	}
	doubleListNode newNode = new doubleListNode(key, value);
	map.put(key, newNode);
	if (length + 1 > capacity) {
	    doubleListNode tmp = head.next;
	    head.next = head.next.next;
	    head.next.prev = head;
	    map.remove(tmp.key);
	    length--;
	}
	newNode.next = tail;
	newNode.prev = tail.prev;
	tail.prev.next = newNode;
	tail.prev = newNode;
	length++;
    }
}