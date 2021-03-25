/**
 * @author yanliu
 * @create 2021-03-08-17:29
 */
public class AddTwoNumbers {
    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(0);
            ListNode tail = dummy;

            // record the sum
            int sum = 0;

            while (l1 != null || l2 != null || sum > 0) {
                sum += (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);

                // record current position sum
                tail.next = new ListNode(sum % 10);
                tail = tail.next;

                if (l1 != null) {
                    l1 = l1.next;
                }

                if (l2 != null) {
                    l2 = l2.next;
                }

                // get out of the current position number
                sum = sum / 10;
            }

            return dummy.next;
        }
    }
}
