/**
 * @author yanliu
 * @create 2020-12-08-20:27
 */
public class ReverseKGroup {
    static class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null) {
                return null;
            }

            ListNode a, b;
            a = b = head;

            for (int i = 0; i < k; i++) {
                // base case (the number of left nodes less than k)
                if (b == null) {
                    return head;
                }

                b = b.next;
            }

            ListNode newHead = reverseBetween(a, b);
            a.next = reverseKGroup(b, k);

            return newHead;
        }

        /**
         * reverse linked-list between [a, b)
         * @param a
         * @param b
         * @return
         */
        private ListNode reverseBetween(ListNode a, ListNode b) {
            ListNode pre, curr, next;

            pre = null; curr = a; next = null;

            while (curr != b) {
                next = curr.next;
                curr.next = pre;
                pre = curr;
                curr = next;
            }

            return pre;
        }
    }
}
