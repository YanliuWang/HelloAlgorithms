/**
 * LeetCode83
 * @author yanliu
 * @create 2022-02-09-10:36 PM
 */
public class RemoveDuplicatesFromSortedList {
    static class Solution {
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
}
