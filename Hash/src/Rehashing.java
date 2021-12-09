/**
 * lintcode 129
 * @author yanliu
 * @create 2021-10-30-11:54 AM
 */
public class Rehashing {
     public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
             next = null;
         }

     }

    public class Solution {
        /**
         * @param hashTable: A list of The first node of linked list
         * @return: A list of The first node of linked list which have twice size
         */
        public ListNode[] rehashing(ListNode[] hashTable) {
            // write your code here
            if (hashTable == null || hashTable.length == 0) {
                return hashTable;
            }

            int newCapacity = hashTable.length * 2;
            ListNode[] newHashTable = new ListNode[newCapacity];

            for (ListNode hashNode : hashTable) {
                if (hashNode == null) {
                    // no element in the current bucket
                    continue;
                }

                ListNode curr = hashNode;

                while (curr != null) {
                    toNewHashTable(curr.val, newHashTable);
                    curr = curr.next;
                }
            }

            return newHashTable;
        }

        private void toNewHashTable(int key, ListNode[] newHashTable) {
            int hashCode = getHashCode(key, newHashTable.length);

            if (newHashTable[hashCode] == null) {
                newHashTable[hashCode] = new ListNode(key);
                return;
            }

            ListNode dummy = newHashTable[hashCode];

            while (dummy.next != null) {
                dummy = dummy.next;
            }

            dummy.next = new ListNode(key);
        }

        private int getHashCode(int key, int capacity) {
            return (key % capacity + capacity) % capacity;
        }
    }
}
