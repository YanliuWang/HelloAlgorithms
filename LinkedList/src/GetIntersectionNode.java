/**
 * LeetCode 160
 * @author yanliu
 * @create 2021-11-12-11:52 AM
 */
public class GetIntersectionNode {
    static class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            // pretend to connect the two linked list
            ListNode p1 = headA, p2 = headB;

            while (p1 != p2) {
                if (p1 == null) {
                    p1 = headB;

                } else {
                    p1 = p1.next;
                }

                if (p2 == null) {
                    p2 = headA;

                } else {
                    p2 = p2.next;
                }
            }

            return p1;
        }
    }
}
