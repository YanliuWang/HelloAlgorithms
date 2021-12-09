/**
 * LeetCode 141
 * @author yanliu
 * @create 2021-11-12-11:35 AM
 */
public class HasCycle {
    static class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null) {
                return false;
            }

            ListNode slow = head, fast = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;

                if (fast == slow) {
                    return true;
                }
            }

            return false;
        }
    }
}
