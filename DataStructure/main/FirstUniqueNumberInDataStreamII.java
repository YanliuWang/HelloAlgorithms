
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/** LintCode 960 · First Unique Number in Data Stream II
 * @author yanliu
 * @create 2021-07-30-12:23
 */
public class FirstUniqueNumberInDataStreamII {
    /**
     * using single linked list
     */
    static class Solution1 {
        class ListNode {
            public int val;
            public ListNode next;

            public ListNode(int val) {
                this.val = val;
            }
        }

        // dummy node is the previous node of head
        ListNode dummy;

        // tail node is used to insert node to the linked list
        ListNode tail;

        // hash set to store duplicates
        Set<Integer> duplicates;

        // store integer to previous node pairs
        // use the previous node to delete the target node
        Map<Integer, ListNode> numToPrev;


        public Solution1() {
            // do initialization if necessary
            dummy = new ListNode(-1);
            tail = dummy;
            duplicates = new HashSet<>();
            numToPrev = new HashMap<>();
        }

        /**
         * @param num: next number in stream
         * @return: nothing
         */
        public void add(int num) {
            // write your code here

            // the num appears twice, do nothing
            if (duplicates.contains(num)) {
                return;
            }

            // if we firstly meet the num
            if (!numToPrev.containsKey(num)) {
                addToListTail(num);
                return;
            }

            // if we secondly meet the num
            // remove the number from linked list
            remove(num);
            // add the number to duplicates set
            duplicates.add(num);

            return;
        }

        private void addToListTail(int val) {
            tail.next = new ListNode(val);
            numToPrev.put(val, tail);

            tail = tail.next;
        }

        private void remove(int num) {
            ListNode prev = numToPrev.get(num);
            ListNode next = prev.next.next;
            prev.next = next;

            numToPrev.remove(num);

            // if we remove the tail node
            if (next == null) {
                tail = prev;
            } else {
                // if we remove the mid node
                // we need to update the next node map pair
                // the next node needs to point to the previous node
                numToPrev.put(next.val, prev);
            }

        }

        /**
         * @return: the first unique number in stream
         */
        public int firstUnique() {
            // write your code here
            if (dummy.next != null) {
                return dummy.next.val;
            }

            return -1;
        }
    }

    static class Solution2 {
        // double linked list node definition
        class DoubleLinkedListNode {
            public int val;
            public DoubleLinkedListNode prev;
            public DoubleLinkedListNode next;

            public DoubleLinkedListNode(int val) {
                this.val = val;
                this.prev = null;
                this.next = null;
            }
        }

        // dummy node to lead the linked list
        private DoubleLinkedListNode dummy;
        // tail node to insert the new node
        private DoubleLinkedListNode tail;
        // set to store duplicate numbers(appears twice)
        private Set<Integer> duplicates;
        // map to store num node pair
        private Map<Integer, DoubleLinkedListNode> numToNode;


        public Solution2() {
            // do initialization if necessary
            dummy = new DoubleLinkedListNode(-1);
            tail = dummy;
            duplicates = new HashSet<>();
            numToNode = new HashMap<>();
        }

        /**
         * @param num: next number in stream
         * @return: nothing
         */
        public void add(int num) {
            // write your code here
            // 如果已经出现两次了
            if (duplicates.contains(num)) {
                return;
            }

            // 如果这个数字是第二次出现
            if (numToNode.containsKey(num)) {
                // remove the node from linked list and map
                remove(num);
                // add the num to duplicates Set
                duplicates.add(num);

            } else {
                // 如果这个数字是第一次出现
                addToListTail(num);

            }
        }

        private void remove(int num) {
            DoubleLinkedListNode deleteNode = numToNode.get(num);
            DoubleLinkedListNode prev = deleteNode.prev;
            prev.next = deleteNode.next;

            if (deleteNode.next != null) {
                deleteNode.next.prev = prev;

            } else {
                // if we delete the tail node
                tail = prev;
            }

            numToNode.remove(num);

        }

        private void addToListTail(int num) {
            tail.next = new DoubleLinkedListNode(num);
            tail.next.prev = tail;
            tail = tail.next;

            numToNode.put(num, tail);
        }

        /**
         * @return: the first unique number in stream
         */
        public int firstUnique() {
            // write your code here
            if (dummy.next != null) {
                return dummy.next.val;
            }

            return -1;
        }
    }

}
