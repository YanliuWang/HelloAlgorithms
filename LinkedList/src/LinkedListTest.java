/**
 * @author yanliu
 * @create 2020-10-16-13:41
 */
public class LinkedListTest {
    @org.junit.Test
    public void testReverseLinkedList() {
        ReverseLinkedList.Solution solution = new ReverseLinkedList().new Solution();

        ReverseLinkedList.ListNode head = new ReverseLinkedList().new ListNode(1);
        head.next = new ReverseLinkedList().new ListNode(2);
        head.next.next = new ReverseLinkedList().new ListNode(3);
        head.next.next.next = new ReverseLinkedList().new ListNode(4);

        ReverseLinkedList.ListNode curr = head;

        while (curr != null) {
            System.out.print(curr.val +" ");
            curr = curr.next;
        }


        curr = solution.reverseList(head);
        System.out.println("\n" + "after reverse");

        while (curr != null) {
            System.out.print(curr.val +" ");
            curr = curr.next;
        }
    }
}
