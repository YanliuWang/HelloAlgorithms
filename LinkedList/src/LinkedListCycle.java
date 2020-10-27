/**
 * @author yanliu
 * @create 2020-10-27-10:40
 */
public class LinkedListCycle {
    static class Solution {
        public ListNode detectCycle(ListNode head) {
            if (head == null || head.next == null) {
                return null;
            }

            ListNode tortoise = head;
            ListNode hare = head;
            boolean isCycle = false;

            while (tortoise != null && hare != null) {
                tortoise = tortoise.next;

                // use the pointer which is constant so far
                if (hare.next == null) {
                    return null;
                }

                hare = hare.next.next;

                if (hare == tortoise) {
                    isCycle = true;
                    break;
                }
            }

            if (isCycle == false) {
                return null;
            }

            tortoise = head;

            while (tortoise != hare) {
                tortoise = tortoise.next;
                hare = hare.next;
            }

            return tortoise;
        }
    }
}
