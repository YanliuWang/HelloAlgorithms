import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode146
 * @author yanliu
 * @create 2020-11-01-10:27
 */

public class LRUCache {
    class Node {
        public int key, value;
        public Node prev, next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    class DoubleLinkedList {
        public Node head, tail;
        public int size;


        public DoubleLinkedList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);

            head.next = tail;
            tail.prev = head;
        }

        public void addToTail(Node node) {
            Node prev = tail.prev;

            node.next = tail;
            tail.prev = node;

            prev.next = node;
            node.prev = prev;

            size++;
        }

        public Node removeFromHead() {
            if (head.next == tail) {
                return null;
            }

            Node first = head.next;

            head.next = first.next;
            first.next.prev = head;

            first.next = null;
            first.prev = null;

            size--;

            return first;
        }

        public void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;

            node.next = null;
            node.prev = null;

            size--;
        }

        public int size() {
            return size;
        }
    }

    private DoubleLinkedList cache;
    private int capacity;
    private Map<Integer, Node> keyToNode;


    public LRUCache(int capacity) {
        cache = new DoubleLinkedList();
        this.capacity = capacity;
        keyToNode = new HashMap<>();
    }

    public int get(int key) {
        if (!keyToNode.containsKey(key)) {
            return -1;
        }

        Node node = keyToNode.get(key);
        makeMostRecently(key);

        return node.value;

    }

    public void put(int key, int value) {
        if (keyToNode.containsKey(key)) {
            deleteFromCache(key);
            addMostRecently(key, value);
            return;
        }

        if (cache.size() == capacity) {
            removeLeastRecently();
        }

        addMostRecently(key, value);
    }

    private void addMostRecently(int key, int value) {
        Node node = new Node(key, value);
        cache.addToTail(node);
        keyToNode.put(key, node);

    }

    private void makeMostRecently(int key) {
        Node node = keyToNode.get(key);
        cache.remove(node);
        cache.addToTail(node);
    }

    private void removeLeastRecently() {
        Node first = cache.removeFromHead();
        keyToNode.remove(first.key);
    }

    private void deleteFromCache(int key) {
        Node node = keyToNode.get(key);
        keyToNode.remove(key);
        cache.remove(node);
    }
}
