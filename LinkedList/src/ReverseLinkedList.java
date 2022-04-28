/**
 * LeetCode206
 * @author yanliu
 * @create 2020-10-16-13:29
 */
public class ReverseLinkedList {
    static class Solution1 {
        public ListNode reverseLinkedList(ListNode head) {
            ListNode prev = null, curr = head, next      ;

            while (curr != null) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            return prev;

        }
    }

    static class Solution2 {
        public ListNode reverseLinkedList(ListNode head) {
            if (head == null) {
                return null;
            }

            if (head.next == null) {
                return head;
            }

            ListNode newHead = reverseLinkedList(head.next);

            // point to the current node
            head.next.next = head;

            // current node as the final one
            head.next = null;

            return newHead                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    ;
        }
    }
}
