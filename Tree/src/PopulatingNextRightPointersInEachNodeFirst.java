/**
 * @author yanliu
 * @create 2020-11-11-13:39
 */
public class PopulatingNextRightPointersInEachNodeFirst {
    static class Solution {
        /**
         * recursion
         * @param root
         * @return
         */
        public Node constructRecursion(Node root) {
            if (root == null) {
                return null;
            }

            if (root.left != null) {
                root.left.next = root.right;
            }

            if (root.right != null && root.next != null) {
                root.right.next = root.next.left;
            }

            constructRecursion(root.left);
            constructRecursion(root.right);

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
