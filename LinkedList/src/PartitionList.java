/**
 * LeetCode86
 * @author yanliu
 * @create 2022-02-17-9:35 AM
 */
public class PartitionList {
    static class Solution {
        public ListNode partition(ListNode head, int x) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode beforeDummy = new ListNode(-1);
            ListNode afterDummy = new ListNode(-1);

            ListNode before = beforeDummy;
            ListNode after = afterDummy;

            ListNode curr = head;

            while (curr != null) {
                if (curr.val < x) {
                    before.next = curr;
                    before = before.next;

                } else {
                    after.next = curr;
                    after = after.next;
                }

                curr = curr.next;
            }

            before.next = afterDummy.next;

            after.next = null;

            return beforeDummy.next;
        }
    }
}
