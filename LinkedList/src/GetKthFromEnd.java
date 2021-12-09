/**
 * 剑指offer 22
 * @author yanliu
 * @create 2021-11-12-10:47 AM
 */
public class GetKthFromEnd {
    static class Solution {
        public ListNode getKthFromEnd(ListNode head, int k) {
            ListNode p1 = head, p2 = head;

            // first move the p1 -> kth node
            for (int i = 0; i < k; i++) {
                p1 = p1.next;
            }

            // second move the p1 and p2 at the same time
            while (p1 != null) {
                p1 = p1.next;
                p2 = p2.next;
            }

            return p2;
        }
    }
}
