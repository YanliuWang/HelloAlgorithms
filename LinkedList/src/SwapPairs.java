/**
 * @author yanliu
 * @create 2020-12-27-15:28
 */
public class SwapPairs {
    static class Solution1 {
        public ListNode swapPairs(ListNode head) {
            if (head == null) {
                return null;
            }

            return reverseTwoGroup(head, 2);
        }

        private ListNode reverseTwoGroup(ListNode head, int k) {
            if (head == null) {
                return null;
            }

            ListNode a = head, b = head;

            for (int i = 0; i < k; i++) {
                if (b == null) {
                    return head;
                }

                b = b.next;
            }

            ListNode newHead = reverseBetween(a, b);
            a.next = reverseTwoGroup(b, k);

            return newHead;
        }

        private ListNode reverseBetween(ListNode a, ListNode b) {
            ListNode curr = a, pre = null, next = null;

            while (curr != b) {
                next = curr.next;
                curr.next = pre;
                pre = curr;
                curr = next;
            }

            return pre;
        }
    }

    static class Solution2 {
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode firstNode = head;
            ListNode secondNode = head.next;

            firstNode.next = swapPairs(secondNode.next);
            secondNode.next = firstNode;

            return secondNode;
        }
    }

}
