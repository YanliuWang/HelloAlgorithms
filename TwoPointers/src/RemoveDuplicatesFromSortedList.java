/**
 * @author yanliu
 * @create 2021-12-18-11:15 PM
 */
public class RemoveDuplicatesFromSortedList {
    /**
     * LeetCode83
     */
    static class Solution1 {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode dummy = new ListNode(-1, head);
            ListNode pre = dummy, curr = dummy.next;

            while (curr != null) {
                while (curr.next != null && curr.next.val == curr.val) {
                    curr = curr.next;
                }

                pre.next = curr;
                pre = curr;
                curr = curr.next;
            }

            return dummy.next;
        }
    }

    /**
     * LeetCode82
     */
    static class Solution2 {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode dummy = new ListNode(Integer.MIN_VALUE);
            dummy.next = head;

            ListNode pre = dummy, curr = dummy.next;

            while (curr != null) {
                while (curr.next != null && curr.next.val == curr.val) {
                    curr = curr.next;
                }

                if (pre.next == curr) {
                    pre = curr;

                } else {
                    pre.next = curr.next;
                }

                curr = curr.next;
            }

            return dummy.next;
        }
    }
}
