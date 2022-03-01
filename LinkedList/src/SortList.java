import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * LeetCode148
 * @author yanliu
 * @create 2022-02-23-7:41 PM
 */
public class SortList {
    static class Solution1 {
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            PriorityQueue<Integer> heap = new PriorityQueue<>(
                    new Comparator<Integer>() {
                        public int compare(Integer o1, Integer o2) {
                            return o1 - o2;
                        }
                    });

            while (head != null) {
                heap.offer(head.val);
                head = head.next;
            }

            ListNode dummy = new ListNode(-1);
            ListNode tail = dummy;

            while (!heap.isEmpty()) {
                tail.next = new ListNode(heap.poll());
                tail = tail.next;
            }

            return dummy.next;
        }
    }
}
