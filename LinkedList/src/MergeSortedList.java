/**
 * LeetCode 21
 * @author yanliu
 * @create 2020-10-16-15:28
 */
public class MergeSortedList {
    static class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(-1);
            ListNode tail = dummy;
            ListNode p1 = l1, p2 = l2;

            while (p1 != null && p2 != null) {
                if (p1.val < p2.val) {
                    tail.next = p1;
                    p1 = p1.next;

                } else {
                    tail.next = p2;
                    p2 = p2.next;
                }

                tail = tail.next;
            }

            if (p1 != null) {
                tail.next = p1;
            }

            if (p2 != null) {
                tail.next = p2;
            }

            return dummy.next;
        }
    }
}
