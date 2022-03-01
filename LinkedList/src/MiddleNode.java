/**
 * LeetCode 876
 * @author yanliu
 * @create 2021-11-12-11:31 AM
 */
public class MiddleNode {
    static class Solution1 {
        public ListNode middleNode(ListNode head) {
            ListNode slow = head, fast = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            return slow;
        }
    }

    static class Solution2 {
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode mid = getMid(head);
            ListNode left = sortList(head);
            ListNode right = sortList(mid);

            return merge(left, right);
        }

        private ListNode merge(ListNode l1, ListNode l2) {
            ListNode p1 = l1, p2 = l2;
            ListNode dummy = new ListNode(-1);
            ListNode tail = dummy;

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

            if (p1 == null) {
                tail.next = p2;

            }

            if (p2 == null) {
                tail.next = p1;
            }

            return dummy.next;
        }

        private ListNode getMid(ListNode head) {
            ListNode midPrev = null;

            while (head != null && head.next != null) {
                midPrev = midPrev == null ? head : midPrev.next;
                head = head.next.next;
            }

            ListNode mid = midPrev.next;
            midPrev.next = null;

            return mid;

        }
    }
}
