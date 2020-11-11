/**
 * @author yanliu
 * @create 2020-11-11-13:40
 */
class Node {
    int val;
    Node left;
    Node right;
    Node next;

    public Node() {}

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node left, Node right, Node next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}
