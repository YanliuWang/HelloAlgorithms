/**
 * LeetCode 142
 * @author yanliu
 * @create 2020-10-27-10:40
 */
public class DetectCycle {
    static class Solution {
        ListNode detectCycle(ListNode head) {
            if (head == null || head.next == null) {
                return null;
            }

            ListNode slow = head, fast = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;

                if (fast == slow) {
                    break;
                }
            }

            // check whether the linked list has a cycle

            // no cycle
            if (fast == null || fast.next == null) {
                return null;
            }

            // has a cycle
            slow = head;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }

            return slow;
        }
    }
}
