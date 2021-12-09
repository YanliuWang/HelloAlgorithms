/**
 * LeetCode 876
 * @author yanliu
 * @create 2021-11-12-11:31 AM
 */
public class MiddleNode {
    static class Solution {
        public ListNode middleNode(ListNode head) {
            ListNode slow = head, fast = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            return slow;
        }
    }
}
