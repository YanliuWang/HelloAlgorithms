/**
 * @author yanliu
 * @create 2022-02-09-10:36 PM
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

            ListNode dummy = new ListNode(-1);
            dummy.next = head;

            ListNode slow = head, fast = head;

            while (fast != null) {
                if (fast.val != slow.val) {
                    slow.next = fast;
                    slow = slow.next;

                }

                fast = fast.next;
            }

            slow.next = null;

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

            ListNode dummy = new ListNode(0);
            dummy.next = head;

            ListNode prev = dummy, curr = head;

            while (curr != null) {
                if (curr.next != null && curr.next.val == curr.val) {
                    while (curr.next != null && curr.next.val == curr.val) {
                        curr = curr.next;
                    }

                    prev.next = curr.next;

                } else {
                    prev = prev.next;

                }

                curr = curr.next;
            }

            return dummy.next;
        }
    }
}
