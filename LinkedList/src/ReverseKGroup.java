/**
 * @author yanliu
 * @create 2020-12-08-20:27
 */
public class ReverseKGroup {
    static class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            // base case 1
            if (head == null) {
                return null;
            }

            ListNode a, b;
            a = b = head;

            // base case 2
            // [a, b) is not multiple of k
            // return as it is
            for (int i = 0; i < k; i++) {
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
            ListNode pre = null, curr = a, next = null;

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
