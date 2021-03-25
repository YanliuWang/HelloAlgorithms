/**
 * @author yanliu
 * @create 2021-03-10-12:33
 */
public class MyLinkedList {
    private ListNode head;
    private ListNode tail;
    private int size;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = new ListNode(0);
        tail = head;
        size = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }

        ListNode curr = head;

        for (int i = 0; i <= index; i++) {
            curr = curr.next;
        }

        return curr.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode newHead = new ListNode(val);

        newHead.next = head.next;
        head.next = newHead;

        if (this.size == 0) {
            tail = newHead;
        }

        this.size++;

    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val);
        tail.next = newNode;
        tail = tail.next;

        this.size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }

        ListNode prev = head;

        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        ListNode newNode = new ListNode(val);

        newNode.next = prev.next;
        prev.next = newNode;

        this.size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        ListNode prev = head;

        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        ListNode curr = prev.next;
        prev.next = curr.next;

        this.size--;
    }

}