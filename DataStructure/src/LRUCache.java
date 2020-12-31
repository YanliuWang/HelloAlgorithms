import java.util.HashMap;

/**
 * @author yanliu
 * @create 2020-12-31-10:13
 */
public class LRUCache {
    private HashMap<Integer, Node> map;
    private DoubleList cache;
    private int cap;

    public LRUCache(int cap) {
        this.cap = cap;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    /**
     * 根据 key 获取 val
     * @param key
     * @return
     */
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        makeRecentlyUsed(key);
        return map.get(key).val;
    }

    public void put(int key, int val) {
        if (map.containsKey(key)) {
            deleteKey(key);

        } else {
            if (cap == cache.size()) {
                removeLeastRecently();
            }

        }

        addRecently(key, val);

    }

    /**
     * 将某个 key 提升为最近使用
     * @param key
     */
    private void makeRecentlyUsed(int key) {
        Node x = map.get(key);
        cache.remove(x);
        cache.addLast(x);
    }

    /**
     * 添加 node 到最近使用的
     * @param key
     * @param val
     */
    private void addRecently(int key, int val) {
        Node x = new Node(key, val);
        map.put(key, x);
        cache.addLast(x);
    }

    /**
     * 根据 key 删除节点
     * @param key
     */
    private void deleteKey(int key) {
        Node x = map.get(key);
        cache.remove(x);
        map.remove(key);
    }

    /**
     * 删除最久未使用的节点
     */
    private void removeLeastRecently() {
        Node x = cache.removeFirst();
        // 根据 key 去 map 删除元素，所以节点中需要存储 key
        map.remove(x.key);
    }

}

class Node {
    public int key, val;
    public Node prev, next;

    public Node(int k, int v) {
        key = k;
        val = v;
    }
}

class DoubleList {
    private Node head, tail;
    private int size;

    public DoubleList() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;

    }

    /**
     * add the node x to the end of the list
     * Time Complexity is O(1)
     * @param x
     */
    public void addLast(Node x) {
        x.prev = tail.prev;
        x.next = tail;
        tail.prev.next = x;
        tail.prev = x;
        size++;
    }

    /**
     * delete the node x in the list
     * because the list is Double LinkedList
     * Time Complexity is O(1)
     * @param x
     */
    public void remove(Node x) {
        x.prev.next = x.next;
        x.next.prev = x.prev;
        x.prev = null;
        x.next = null;
        size--;
    }

    /**
     * remove the first node and return it
     * @return
     */
    public Node removeFirst() {
        // the list is empty
        if (head.next == tail) {
            return null;
        }

        Node first = head.next;
        remove(first);

        return first;

    }

    /**
     * get the size of the linked list
     * * @return
     */
    public int size() {
        return size;
    }
}
