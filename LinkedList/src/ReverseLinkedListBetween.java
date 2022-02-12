//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
//
// 说明:
//1 ≤ m ≤ n ≤ 链表长度。
//
// 示例:
//
// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL
// Related Topics 链表
// 👍 581 👎 0


//leetcode submit region begin(Prohibit modification and deletion)


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
 * LeetCode92
 * @author yanliu
 * @create 2020-11-27-16:26
 */
public class ReverseLinkedListBetween {
    static class Solution1 {
        ListNode successor = null;

        public ListNode reverseBetween(ListNode head, int m, int n) {
            if (m == 1) {
                return reverseN(head, n);
            }

            head.next = reverseBetween(head.next, m - 1, n - 1);

            return head;
        }

        // reverse the first n node after head
        private ListNode reverseN(ListNode head, int n) {
            // base case
            if (n == 1) {
                successor = head.next;
                return head;
            }

            ListNode last = reverseN(head.next, n - 1);

            head.next.next = head;
            head.next = successor;

            return last;
        }
    }


    static class Solution2 {
        public ListNode reverseBetween(ListNode head, int m, int n) {
            if (head == null) {
                return null;
            }

            ListNode dummy = new ListNode(0);
            dummy.next = head;

            ListNode prev = dummy;

            for (int i = 0; i < m - 1; i++) {
                prev = prev.next;
            }

            ListNode recordPrev = prev;

            ListNode curr = prev.next;

            for (int i = 0; i <= n - m; i++) {
                ListNode recordNext = curr.next;
                curr.next = prev;
                prev = curr;
                curr = recordNext;
            }

            recordPrev.next.next = curr;
            recordPrev.next = prev;

            return dummy.next;

        }

    }

    static class Solution3 {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode curr = head;
            ListNode prev = null, next = null;

            while (left > 1) {
                prev = curr;
                curr = curr.next;
                left--;
                right--;
            }


            ListNode con = prev, tail = curr;

            while (right > 0) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                right--;
            }

            if (con != null) {
                con.next = prev;

            } else {
                head = prev;
            }

            tail.next = curr;

            return head;

        }
    }
}
