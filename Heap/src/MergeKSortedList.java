import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * LeetCode 23
 * @author yanliu
 * @create 2021-04-16-21:36
 */
public class MergeKSortedList {
    static class Solution {
        /**
         * @param lists: a list of ListNode
         * @return: The head of one sorted list.
         */
        public ListNode mergeKLists(List<ListNode> lists) {
            // write your code here
            if (lists == null || lists.size() == 0) {
                return null;
            }

            // construct the min heap
            Comparator<ListNode> comparator = new Comparator<ListNode>() {
                @Override
                public int compare(ListNode o1, ListNode o2) {
                    return o1.val - o2.val;
                }
            };
            PriorityQueue<ListNode> minHeap =
                    new PriorityQueue<>(lists.size(), comparator);

            // put the non-head to minHeap
            for (ListNode listNode : lists) {
                if (listNode != null) {
                    minHeap.add(listNode);
                }
            }

            // build a new list
            ListNode dummy = new ListNode(-1);
            ListNode curr = dummy;

            while (!minHeap.isEmpty()) {
                curr.next = minHeap.poll();
                curr = curr.next;

                if (curr.next != null) {
                    minHeap.add(curr.next);
                }
            }

            return dummy.next;
        }
    }
}
