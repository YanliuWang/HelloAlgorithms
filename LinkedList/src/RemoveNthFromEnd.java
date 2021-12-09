/**
 * LeetCode 19
 * @author yanliu
 * @create 2021-11-12-11:29 AM
 */
public class RemoveNthFromEnd {
    static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(-1);
            dummy.next = head;

            ListNode pre = getFromKthEnd(dummy, n + 1);
            pre.next = pre.next.next;

            return dummy.next;
        }

        private ListNode getFromKthEnd(ListNode head, int k) {
            ListNode p1 = head, p2 = head;

            for (int i = 0; i < k; i++) {
                p2 = p2.next;
            }

            while (p2 != null) {
                p1 = p1.next;
                p2 = p2.next;
            }

            return p1;
        }
    }
}
