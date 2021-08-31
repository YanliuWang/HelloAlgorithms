import java.util.HashMap;
import java.util.Map;
 
/**
 * LintCode 124 LRU Cache
 * @author yanliu
 * @create 2021-08-13-11:49
 */
public class LRUCache {
    class ListNode {
        public int key, val;
        public ListNode next;

        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    // cache capacity
    private int capacity;
    // key to previous node
    private Map<Integer, ListNode> numToPrev;
    // dummy is the previou node of head
    private ListNode dummy;
    // tail is used to insert entry to linked list
    private ListNode tail;
    /*
     * @param capacity: An integer
     */public LRUCache(int capacity) {
        // do intialization if necessary
        this.capacity = capacity;
        this.numToPrev = new HashMap<>();
        dummy = new ListNode(-1, -1);
        tail = dummy;
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        // write your code here
        if (!numToPrev.containsKey(key)) {
            return -1;
        }

        // move to tail when it is recently used
        moveToTail(key);

        return tail.val;
    }


    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        // write your code here
        // the key is on the map
        if (numToPrev.containsKey(key)) {
            moveToTail(key);
            tail.val = value;
            return;
        }

        // the key is not on the map
        pushToTail(new ListNode(key, value));

        if (numToPrev.size() > capacity) {
            popFromFront();
        }

    }

    private void moveToTail(int key) {
        ListNode prev = numToPrev.get(key);
        ListNode deletedNode = prev.next;

        // the deleted node in at the tail
        if (deletedNode.next == null) {
            return;
        }

        // delete the target node
        prev.next = deletedNode.next;
        // update num to prev map
        numToPrev.put(prev.next.key, prev);
        deletedNode.next = null;

        pushToTail(deletedNode);

    }

    private void pushToTail(ListNode node) {
        tail.next = node;
        numToPrev.put(node.key, tail);

        tail = node;
    }

    private void popFromFront() {
        ListNode head = dummy.next;
        dummy.next = head.next;

        numToPrev.remove(head.key);

        numToPrev.put(dummy.next.key, dummy);
    }
}
