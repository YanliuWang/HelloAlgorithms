/**
 * LC2
 * @author yanliu
 * @create 2021-03-08-17:29
 */
public class AddTwoNumbers {
    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            // dummy head to point the result linked list
            ListNode dummy = new ListNode(0);

            // record the tail node
            ListNode tail = dummy;

            // record the sum including 个位之和以及进位
            int sum = 0;

            // 链表不为空或者有进位，则继续
            while (l1 != null || l2 != null || sum > 0) {
                // 计算两个个位的值
                sum += (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);


                // record current position sum
                // %10 记录当前个位的值
                tail.next = new ListNode(sum % 10);
                tail = tail.next;

                if (l1 != null) {
                    l1 = l1.next;
                }

                if (l2 != null) {
                    l2 = l2.next;
                }

                // get the next position num
                // 整除 10 记录进位的值
                sum = sum / 10;
            }

            return dummy.next;
        }
    }
}
