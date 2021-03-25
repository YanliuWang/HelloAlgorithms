/**
 * @author yanliu
 * @create 2021-03-09-22:50
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        // insert node between tail and tail.next
        ListNode tail = dummy;

        while (head != null) {
            // we record the next insertion node
            ListNode next = head.next;

            // if the last insert val is larger that current val
            // we went to the first node
            if (tail.val >= head.val) {
                tail = dummy;
            }

            while (tail.next != null && tail.next.val < head.val) {
                tail = tail.next;
            }

            // insert current node between tail and tail.next
            head.next = tail.next;
            tail.next = head;

            head = next;
        }

        return dummy.next;

    }
}
