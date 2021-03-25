//反转一个单链表。
//
// 示例:
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL
//
// 进阶:
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
// Related Topics 链表
// 👍 1279 👎 0

/**
 * @author yanliu
 * @create 2020-10-16-13:29
 */
public class ReverseLinkedList {
    static class Solution1 {
        public ListNode reverseLinkedList(ListNode head) {
            ListNode prev = null, curr = head, next      ;

            while (curr != null) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            return prev;

        }
    }

    static class Solution2 {
        public ListNode reverseLinkedList(ListNode head) {
            if (head == null) {
                return null;
            }

            if (head.next == null) {
                return head;
            }

            ListNode newHead = reverseLinkedList(head.next);

            // point to the current node
            head.next.next = head;

            // current node as the final one
            head.next = null;

            return newHead                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    ;
        }
    }
}
