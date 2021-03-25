import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author yanliu
 * @create 2021-03-09-18:20
 */
public class MergeKSortedLists {
    static class Solution1 {
        public ListNode mergeKLists(ListNode[] lists) {
            return merge(lists, 0, lists.length - 1);
        }

        private ListNode merge(ListNode[] lists, int l, int r) {
            if (l > r) {
                return null;
            }

            if (l == r) {
                return lists[l];
            }

            int mid = l + (r - l) / 2;

            return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
        }

        private ListNode mergeTwoLists(ListNode a, ListNode b) {
            if (a == null || b == null) {
                return a == null ? b : a;
            }

            ListNode dummy = new ListNode(0);
            ListNode tail = dummy;

            while (a != null && b != null) {
                if (a.val < b.val) {
                    tail.next = a;
                    a = a.next;
                } else {
                    tail.next = b;
                    b = b.next;
                }

                tail = tail.next;
            }

            tail.next = a == null ? b : a;

            return dummy.next;
        }
    }

    static class Solution2 {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) {
                return null;
            }

            if (lists.length == 1) {
                return lists[0];
            }

            PriorityQueue<ListNode> heap = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
                @Override
                public int compare(ListNode o1, ListNode o2) {
                    if (o1.val < o2.val) {
                        return -1;
                    } else if (o1.val == o2.val) {
                        return 0;
                    } else {
                        return 1;
                    }
                }
            });

            for (ListNode node : lists) {
                if (node != null) {
                    heap.add(node);
                }
            }

            ListNode dummy = new ListNode(0);
            ListNode tail = dummy;

            while (!heap.isEmpty()) {
                tail.next = heap.poll();
                tail = tail.next;

                if (tail.next != null) {
                    heap.offer(tail.next);
                }

            }

            return dummy.next;
        }
    }
}
