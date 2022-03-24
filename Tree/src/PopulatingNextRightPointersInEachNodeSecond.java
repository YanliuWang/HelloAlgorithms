/**
 * LeetCode117
 * @author yanliu
 * @create 2020-11-11-14:58
 */
public class PopulatingNextRightPointersInEachNodeSecond {
    /**
     * iterative solution
     */
    static class Solution1 {
        public Node connect(Node root) {
            if (root == null) {
                return null;
            }

            Node firstNode = root;

            while (firstNode != null) {
                Node currNodeAtLevel = firstNode;

                while (currNodeAtLevel != null) {
                    if (currNodeAtLevel.left != null) {
                        if (currNodeAtLevel.right != null) {
                            currNodeAtLevel.left.next = currNodeAtLevel.right;

                        } else {
                            currNodeAtLevel.left.next = getClosestChild(currNodeAtLevel.next);

                        }
                    }

                    if (currNodeAtLevel.right != null) {
                        currNodeAtLevel.right.next = getClosestChild(currNodeAtLevel.next);

                    }

                    currNodeAtLevel = currNodeAtLevel.next;

                }

                firstNode = getNextFirstNode(firstNode);

            }

            return root;
        }

        private Node getClosestChild(Node node) {
            if (node == null) {
                return null;
            }

            while (node != null) {
                if (node.left != null) {
                    return node.left;
                }

                if (node.right != null) {
                    return node.right;
                }

                node = node.next;
            }

            return null;
        }

        private Node getNextFirstNode(Node node) {
            while (node != null) {
                if (node.left != null) {
                    return node.left;

                }

                if (node.right != null) {
                    return node.right;

                }

                node = node.next;
            }

            return null;
        }
    }
}
