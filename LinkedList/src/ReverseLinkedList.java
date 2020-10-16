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
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }

    }

    public class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode prevHead = null;

            while (head != null) {
                ListNode recordNext = head.next;
                head.next = prevHead;
                prevHead = head;
                head = recordNext;
            }

            return prevHead;

        }
    }
}
