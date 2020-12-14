/**
 * @author yanliu
 * @create 2020-11-11-13:39
 */
public class PopulatingNextRightPointersInEachNodeFirst {
    static class Solution {
        /**
         * recursion1
         * @param root
         * @return
         */
        public Node construct(Node root) {
            if (root == null) {
                return null;
            }

            constructRecursionFirst(root.left, root.right);

            return root;
        }

        private void constructRecursionFirst(Node node1, Node node2) {
            if (node1 == null || node2 == null) {
                return;
            }

            // preorder traverse
            // connect two nodes
            node1.next = node2;

            // connect two nodes with same root
            constructRecursionFirst(node1.left, node1.right);
            constructRecursionFirst(node2.left, node2.right);

            // connect two nodes with different root
            constructRecursionFirst(node1.right, node2.left);
        }

        /**
         * recursion2
         * @param root
         * @return
         */
        public Node constructRecursionSecond(Node root) {
            if (root == null) {
                return null;
            }

            if (root.left != null) {
                root.left.next = root.right;
            }

            if (root.right != null && root.next != null) {
                root.right.next = root.next.left;
            }

            constructRecursionSecond(root.left);
            constructRecursionSecond(root.right);

            return root;
        }

        /**
         * iteration
         * @param root
         * @return
         */
        public Node constructIteration(Node root) {
            if (root == null) {
                return null;
            }

            Node firstNodeAtLevel = root;

            while (firstNodeAtLevel != null) {
                Node currentNodeAtLevel = firstNodeAtLevel;

                while (currentNodeAtLevel != null) {
                    if (currentNodeAtLevel.left != null) {
                        currentNodeAtLevel.left.next = currentNodeAtLevel.right;
                    }

                    if (currentNodeAtLevel.right != null && currentNodeAtLevel.next != null) {
                        currentNodeAtLevel.right.next = currentNodeAtLevel.next.left;
                    }

                    currentNodeAtLevel = currentNodeAtLevel.next;
                }

                firstNodeAtLevel = firstNodeAtLevel.left;
            }

            return root;
        }
    }
}
